package com.namlh.sandocu.domain.reponsitory;

import com.namlh.sandocu.domain.ResultItem;

import java.util.List;

import rx.Observable;

/**
 * Created by namlh on 03/08/2015.
 */
public interface ResultsRepository {
    Observable<List<ResultItem>> getResults(String keyword);
}
