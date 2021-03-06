package com.namlh.sandocu.data.reponsitory.datasource;

import com.namlh.sandocu.data.entity.NhatTaoProduct;
import com.namlh.sandocu.data.entity.Product;
import com.namlh.sandocu.data.jsoup.ParseNhatTaoObservable;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by namlh on 05/08/2015.
 */
@Singleton
public class NhatTaoDatasource {

    private final ParseNhatTaoObservable parseNhatTao;

    @Inject
    public NhatTaoDatasource(ParseNhatTaoObservable parseNhatTaoObservable) {
        this.parseNhatTao = parseNhatTaoObservable;
    }

    public Observable<List<Product>> getResult(String keyword) {
        return parseNhatTao.get(keyword)
                .map(elements -> {
                    List<Product> products = new ArrayList<>();
                    for (Element e : elements) {
                        try {
                            NhatTaoProduct product = new NhatTaoProduct();
                            product.setTitle(getTitle(e));
                            product.setDateTime(getDateTime(e));
                            product.setLocation(getLocation(e));
                            product.setLink(getLink(e));
                            product.setTimeInMillisecond(getTimeInMillisecond(e));
                            product.setId(getProductId(e));
                            product.setImageUrl(getImageUrl(e));
                            product.setPrice(getPrice(e));
                            products.add(product);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    return products;
                });
    }

    private double getPrice(Element e) {
        Elements priceElements = e.select(".meta .classified_thread_list_price .text");
        if (priceElements.size() >0){
            String price = priceElements.get(0).text()
                    .replace(",","")
                    .replace(" VND","");
            return Double.parseDouble(price);
        }
        return 0;
    }

    private String getImageUrl(Element e) {
        return e.select(".avatarContainer .avatar img").get(0).attr("src");
    }

    private long getProductId(Element e) {
        String stringId = e.select(".thread").get(0).attr("id");
        return Long.parseLong(stringId.split("-")[1]);
    }

    private long getTimeInMillisecond(Element e) {
        Elements elements = e.select(".meta .DateTime");
        if (elements.size() >0){
            Element element = elements.get(0);
            String sDate = element.attr("data-datestring");
            if (sDate !=null && !sDate.isEmpty()){
                String sTime = element.attr("data-timestring");
                String stringTime = String.format("%s %s",sDate,sTime);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy hh:ss");
                try {
                    return formatter.parse(stringTime).getTime();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
            }
            else {
                String title = element.attr("title");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy 'at' hh:ss");
                try {
                    return formatter.parse(title).getTime();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
            }
            return 0;
        }
        else
            return 0;
    }

    private String getLink(Element e) {
        return e.select(".titleText .title a").attr("abs:href");
    }

    private String getLocation(Element e) {
        return e.select(".meta .locationPrefix").text();
    }

    private String getDateTime(Element e) {
        return e.select(".meta .DateTime").text();
    }

    private String getTitle(Element e) {
        return e.select(".titleText .title a").text();
    }
}
