package com.namlh.sandocu.domain;


/**
 * Created by namlh on 02/08/2015.
 */
public class ResultItem {
    private long id;
    private String title;
    private String link;
    private String location;
    private String dateTime;
    private long timeInMillisecond;
    private String imageUrl;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getTimeInMillisecond() {
        return timeInMillisecond;
    }

    public void setTimeInMillisecond(long timeInMillisecond) {
        this.timeInMillisecond = timeInMillisecond;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
