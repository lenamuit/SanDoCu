package com.namlh.sandocu.data.reponsitory;

import com.namlh.sandocu.data.reponsitory.datasource.ResultsDatastore;
import com.namlh.sandocu.domain.ResultItem;
import com.namlh.sandocu.domain.reponsitory.ResultsRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by namlh on 05/08/2015.
 */
@Singleton
public class DataResultsRepository implements ResultsRepository {

    private final ResultsDatastore datastore;

    @Inject
    public DataResultsRepository(ResultsDatastore datastore) {
        this.datastore = datastore;
    }


    @Override
    public Observable<ResultItem> getResults(String keyword) {

        return datastore.getResult(keyword)
                .map(ResultItem::new);
    }
}
