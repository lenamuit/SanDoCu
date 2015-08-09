package com.namlh.sandocu.domain.reponsitory;

/**
 * Created by namlh on 08/08/2015.
 */
public interface PreferenceRepository {

    long getLastestUpdateTime();
    void saveLastedUpdateTime(long timeInMillisecond);

    String getKeyword();
    void addKeyword(String key);
    void removeKeyword(String key);
    boolean isEmptyKeyword();


}
