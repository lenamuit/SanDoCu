package com.namlh.sandocu.data.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by namlh on 04/08/2015.
 */
public class ParseHtmlObservable implements Observable.OnSubscribe<Elements> {

    private final String url;
    private final String filter;

    ParseHtmlObservable(String url, String filter) {
        this.url = url;
        this.filter = filter;
    }

    public static Observable<Elements> get(String url, String filter) {
        return Observable.create(new ParseHtmlObservable(url, filter));
    }

    @Override
    public void call(Subscriber<? super Elements> subscriber) {
        Document doc = null;
        try {
            subscriber.onStart();
            doc = Jsoup.connect(url).get();
            Elements newsHeadlines = doc.select(filter);
            subscriber.onNext(newsHeadlines);
            subscriber.onCompleted();
        } catch (IOException e) {
            e.printStackTrace();
            subscriber.onError(e);
        }
    }
}
