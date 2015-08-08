package com.namlh.sandocu.data.entity;

/**
 * Created by namlh on 04/08/2015.
 */
public class NhatTaoProduct implements Product {

    private String title;
    private double price;
    private String inForum;
    private String status;
    private String location;
    private String dateTime;
    private long timeInMillisecond;
    private String link;
    private long id;

    public NhatTaoProduct() {
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
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

    @Override
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getTime() {
        return dateTime;
    }

    @Override
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getInForum() {
        return inForum;
    }

    public void setInForum(String inForum) {
        this.inForum = inForum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public long getTimeInMillisecond() {
        return timeInMillisecond;
    }

    public void setTimeInMillisecond(long timeInMillisecond) {
        this.timeInMillisecond = timeInMillisecond;
    }

    public void setId(long id) {
        this.id = id;
    }
}
