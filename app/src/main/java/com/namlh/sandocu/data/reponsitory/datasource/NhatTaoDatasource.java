package com.namlh.sandocu.data.reponsitory.datasource;

import com.namlh.sandocu.data.entity.NhatTaoProduct;
import com.namlh.sandocu.data.entity.Product;
import com.namlh.sandocu.data.jsoup.ParseNhatTaoObservable;

import org.jsoup.nodes.Element;

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
                        NhatTaoProduct product = new NhatTaoProduct();
                        product.setTitle(getTitle(e));
                        product.setDateTime(getDateTime(e));
                        product.setLocation(getLocation(e));
                        product.setLink(getLink(e));
                        products.add(product);
                    }
                    return products;
                });
    }

    private String getLink(Element e) {
        return e.select(".titleText .title a").get(0).attr("abs:href");
    }

    private String getLocation(Element e) {
        return e.select(".meta .locationPrefix").get(0).text();
    }

    private String getDateTime(Element e) {
        return e.select(".meta .DateTime").get(0).text();
    }

    private String getTitle(Element e) {
        return e.select(".titleText .title a").get(0).text();
    }
}
