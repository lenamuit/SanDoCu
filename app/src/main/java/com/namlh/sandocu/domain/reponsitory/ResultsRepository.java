package com.namlh.sandocu.domain.reponsitory;

import com.namlh.sandocu.domain.ResultItem;

import rx.Observable;

/**
 * Created by namlh on 03/08/2015.
 */
public interface ResultsRepository {
    Observable<ResultItem> getResults(String keyword);
}
