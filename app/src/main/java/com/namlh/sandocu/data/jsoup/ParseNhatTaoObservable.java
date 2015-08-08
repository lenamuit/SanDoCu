package com.namlh.sandocu.data.jsoup;

import android.support.annotation.WorkerThread;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by namlh on 05/08/2015.
 */
@Singleton
public class ParseNhatTaoObservable extends ParseHtmlObservable {

    @Inject
    public ParseNhatTaoObservable() {
    }

    @WorkerThread
    @Override
    public Document getDocument(String keyword) throws IOException {
        Connection.Response loginForm = Jsoup.connect("https://www.nhattao.com/search/")
                .method(Connection.Method.GET)
                .execute();
//            doc = Jsoup.connect("https://www.nhattao.com/search/116255621/?q=nexus&t=thread&o=date&c[title_only]=1&c[location]=HCM").get();
        Document document = Jsoup.connect("https://www.nhattao.com/search/search")
                .data("keywords", "nexus")
                .data("redirect", "true")
                .data("optinout", "optIn")
                .data("title_only","1")
                .cookies(loginForm.cookies())
                .post();
        return document;
    }

    @WorkerThread
    @Override
    public String getCssFilter() {
        return ".searchResultsList .searchResult";
    }
}
