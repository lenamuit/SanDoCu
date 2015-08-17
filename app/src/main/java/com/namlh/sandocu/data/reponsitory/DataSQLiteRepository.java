package com.namlh.sandocu.data.reponsitory;

import android.database.sqlite.SQLiteDatabase;

import com.namlh.sandocu.data.dao.model.DaoMaster;
import com.namlh.sandocu.data.dao.model.DaoSession;
import com.namlh.sandocu.data.dao.model.HuntedItem;
import com.namlh.sandocu.data.dao.model.HuntedItemDao;
import com.namlh.sandocu.domain.ResultItem;
import com.namlh.sandocu.domain.reponsitory.SQLiteRepository;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by namlh on 17/08/2015.
 */
@Singleton
public class DataSQLiteRepository implements SQLiteRepository {

    private final SQLiteDatabase db;

    @Inject
    public DataSQLiteRepository(SQLiteDatabase database){
        this.db = database;
    }

    @Override
    public void saveResultItem(ResultItem resultItem) {
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();

        HuntedItem item = new HuntedItem();
        item.setTitle(resultItem.getTitle());
        item.setCover(resultItem.getImageUrl());
        item.setCreatedAt(new Date());
        item.setPrice(resultItem.getPrice());

        HuntedItemDao huntedItemDao = daoSession.getHuntedItemDao();
        huntedItemDao.insertOrReplace(item);
    }

    @Override
    public Observable<List<ResultItem>> queryAll() {
        return null;
    }
}
