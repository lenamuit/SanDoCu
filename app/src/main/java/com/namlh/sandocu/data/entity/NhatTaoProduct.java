package com.namlh.sandocu.data.entity;

import org.joda.time.DateTime;

/**
 * Created by namlh on 04/08/2015.
 */
public class NhatTaoProduct {

    private String title;
    private double price;
    private String inForum;
    private DateTime dateTime;
    private String status;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInForum() {
        return inForum;
    }

    public void setInForum(String inForum) {
        this.inForum = inForum;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
