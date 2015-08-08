package com.namlh.sandocu.data.reponsitory;

import com.namlh.sandocu.data.reponsitory.datasource.SharePreferenceDatastore;
import com.namlh.sandocu.domain.reponsitory.PreferenceRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by namlh on 08/08/2015.
 */
@Singleton
public class DataPreferenceRepository implements PreferenceRepository{


    private static final String LATEST_UPDATE_TIME = "lasted_update_time";
    private static final String KEY_WORD = "key_word";
    private final SharePreferenceDatastore dataStore;

    @Inject
    public DataPreferenceRepository(SharePreferenceDatastore datastore){
        this.dataStore = datastore;
    }


    @Override
    public long getLastestUpdateTime() {
        return dataStore.getLong(LATEST_UPDATE_TIME);
    }

    @Override
    public void saveLastedUpdateTime(long timeInMillisecond) {
        dataStore.saveLong(LATEST_UPDATE_TIME,timeInMillisecond);
    }

    @Override
    public void saveKeyword(String value) {
        dataStore.saveString(KEY_WORD, value);
    }

    @Override
    public String getKeyword() {
        return dataStore.getString(KEY_WORD);
    }
}
