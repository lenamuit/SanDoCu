package com.namlh.sandocu.data.jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by namlh on 04/08/2015.
 */
public abstract class ParseHtmlObservable implements Observable.OnSubscribe<Elements> {

    private String keyword;

    ParseHtmlObservable() {
    }

    public abstract Document getDocument(String keyword) throws IOException;

    public abstract String getCssFilter();

    @Override
    public void call(Subscriber<? super Elements> subscriber) {
        try {
            subscriber.onStart();
            Elements newsHeadlines = getDocument(keyword).select(getCssFilter());
            subscriber.onNext(newsHeadlines);
            subscriber.onCompleted();
        } catch (IOException e) {
            e.printStackTrace();
            subscriber.onError(e);
        }
    }

    public Observable<Elements> get(String keyword) {
        this.keyword = keyword;
        return Observable.create(this);
    }

}
