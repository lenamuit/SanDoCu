package com.namlh.sandocu.data.entity;

/**
 * Created by namlh on 06/08/2015.
 */
public interface Product {
    long getId();
    String getTitle();

    double getPrice();

    String getLocation();

    String getTime();

    String getLink();

    long getTimeInMillisecond();
}
