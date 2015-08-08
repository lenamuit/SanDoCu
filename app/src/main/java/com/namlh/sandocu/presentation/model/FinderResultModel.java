package com.namlh.sandocu.presentation.model;

/**
 * Created by namlh on 08/08/2015.
 */
public class FinderResultModel {

    public final String title;
    public final String description;
    public final String link;
    public final long id;

    public FinderResultModel(String title, String description, String link, long id) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.id = id;
    }
}
