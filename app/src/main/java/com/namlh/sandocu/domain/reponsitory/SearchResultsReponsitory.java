package com.namlh.sandocu.domain.reponsitory;

import com.namlh.sandocu.domain.SearchResultItem;

import java.util.List;

import rx.Observable;

/**
 * Created by namlh on 03/08/2015.
 */
public interface SearchResultsReponsitory {

    Observable<List<SearchResultItem>> getResults();
}
