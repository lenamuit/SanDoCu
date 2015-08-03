package com.namlh.sandocu.data.entity.mapper;

import com.namlh.sandocu.domain.SearchResultItem;

import org.jsoup.select.Elements;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by namlh on 03/08/2015.
 */
@Singleton
public class ElementToResultMapper {

    @Inject
    public ElementToResultMapper() {

    }

    public SearchResultItem tranform(Elements elements) {
        SearchResultItem item = new SearchResultItem();
        return item;
    }

}
