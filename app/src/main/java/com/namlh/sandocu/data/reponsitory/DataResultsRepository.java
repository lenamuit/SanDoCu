package com.namlh.sandocu.data.reponsitory;

import com.namlh.sandocu.data.entity.Product;
import com.namlh.sandocu.data.reponsitory.datasource.ResultsDatastore;
import com.namlh.sandocu.domain.ResultItem;
import com.namlh.sandocu.domain.reponsitory.ResultsRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

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
    public Observable<List<ResultItem>> getResults(String keyword) {

        return datastore.getResult(keyword)
                .map(new Func1<List<Product>, List<ResultItem>>() {
                    @Override
                    public List<ResultItem> call(List<Product> products) {
                        List<ResultItem> results = new ArrayList<>();
                        for (Product product : products) {
                            ResultItem item = new ResultItem();
                            item.setTitle(product.getTitle());
                            item.setLink(product.getLink());
                            item.setDateTime(product.getTime());
                            item.setLocation(product.getLocation());
                            results.add(item);
                        }
                        return results;
                    }
                });
    }
}
