package com.namlh.sandocu.presentation.model;

/**
 * Created by namlh on 03/08/2015.
 */
public class ResultViewModel {

    public final String title;
    public final double price;
    public final String dateTime;
    public final String location;
    public final String link;
    public final String logoUrl;

    public ResultViewModel(String title, double price, String dateTime, String location, String link, String logoUrl) {
        this.title = title;
        this.price = price;
        this.dateTime = dateTime;
        this.location = location;
        this.link = link;
        this.logoUrl = logoUrl;
    }
    @Override
    public String toString() {
        return title;
    }

}
