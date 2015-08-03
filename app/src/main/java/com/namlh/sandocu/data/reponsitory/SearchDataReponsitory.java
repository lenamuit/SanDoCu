package com.namlh.sandocu.data.reponsitory;

import com.namlh.sandocu.domain.SearchResultItem;
import com.namlh.sandocu.domain.reponsitory.SearchResultsReponsitory;

import java.util.List;

import rx.Observable;

/**
 * Created by namlh on 03/08/2015.
 */
public class SearchDataReponsitory implements SearchResultsReponsitory {

    @Override
    public Observable<List<SearchResultItem>> getResults() {
        return null;
    }
}
