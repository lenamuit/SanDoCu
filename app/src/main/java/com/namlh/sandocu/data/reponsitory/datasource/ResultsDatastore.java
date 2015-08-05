package com.namlh.sandocu.data.reponsitory.datasource;

import com.namlh.sandocu.data.entity.Product;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by namlh on 05/08/2015.
 */
@Singleton
public class ResultsDatastore {

    private final NhatTaoDatasource nhatTao;

    @Inject
    public ResultsDatastore(NhatTaoDatasource nhatTaoDatasource) {
        this.nhatTao = nhatTaoDatasource;
    }

    public Observable<Product> getResult(String keyword) {
        return nhatTao.getResult(keyword);
    }

}
