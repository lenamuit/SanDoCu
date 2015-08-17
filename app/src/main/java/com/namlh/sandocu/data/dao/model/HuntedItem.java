package com.namlh.sandocu.data.dao.model;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "HUNTED_ITEM".
 */
public class HuntedItem {

    private Long id;
    private String title;
    private Double price;
    private String cover;
    private java.util.Date createdAt;

    public HuntedItem() {
    }

    public HuntedItem(Long id) {
        this.id = id;
    }

    public HuntedItem(Long id, String title, Double price, String cover, java.util.Date createdAt) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.cover = cover;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public java.util.Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.util.Date createdAt) {
        this.createdAt = createdAt;
    }

}
