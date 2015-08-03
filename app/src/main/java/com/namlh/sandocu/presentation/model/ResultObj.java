package com.namlh.sandocu.presentation.model;

import java.util.Date;

/**
 * Created by namlh on 03/08/2015.
 */
public class ResultObj {

    private String title;
    private double price;
    private Date dateTime;

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
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
}
