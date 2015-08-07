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

    public ResultViewModel(String title, double price, String dateTime, String location, String link) {
        this.title = title;
        this.price = price;
        this.dateTime = dateTime;
        this.location = location;
        this.link = link;
    }
    @Override
    public String toString() {
        return title;
    }

}
