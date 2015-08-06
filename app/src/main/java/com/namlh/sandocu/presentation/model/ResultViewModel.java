package com.namlh.sandocu.presentation.model;

/**
 * Created by namlh on 03/08/2015.
 */
public class ResultViewModel {

    private String title;
    private double price;
    private String dateTime;
    private String location;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return title;
    }
}
