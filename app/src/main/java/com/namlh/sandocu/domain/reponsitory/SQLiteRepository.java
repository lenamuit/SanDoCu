package com.namlh.sandocu.domain.reponsitory;

import com.namlh.sandocu.domain.ResultItem;

import java.util.List;

import rx.Observable;

/**
 * Created by namlh on 17/08/2015.
 */
public interface SQLiteRepository {
    void saveResultItem(ResultItem resultItem);
    Observable<List<ResultItem>> queryAll();
}
