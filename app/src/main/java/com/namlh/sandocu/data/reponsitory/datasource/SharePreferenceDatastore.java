package com.namlh.sandocu.data.reponsitory.datasource;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by namlh on 08/08/2015.
 */
@Singleton
public class SharePreferenceDatastore {

    private final SharedPreferences sharePreference;

    @Inject
    public SharePreferenceDatastore(Context context){
        this.sharePreference = context.getSharedPreferences("sandocu_pref",Context.MODE_PRIVATE);
    }

    public void saveLong(String key, long value){
        sharePreference.edit().putLong(key,value).apply();
    }

    public long getLong(String key){
        return sharePreference.getLong(key,0);
    }

    public void saveString(String key, String value) {
        sharePreference.edit().putString(key,value).apply();
    }

    public String getString(String key) {
        return sharePreference.getString(key,null);
    }
}
