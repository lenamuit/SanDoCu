package com.namlh.sandocu.presentation.internal.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import com.namlh.sandocu.data.dao.model.DaoMaster;
import com.namlh.sandocu.data.excutor.JobExecutor;
import com.namlh.sandocu.data.reponsitory.DataPreferenceRepository;
import com.namlh.sandocu.data.reponsitory.DataResultsRepository;
import com.namlh.sandocu.data.reponsitory.DataSQLiteRepository;
import com.namlh.sandocu.data.reponsitory.datasource.ResultsDatastore;
import com.namlh.sandocu.data.reponsitory.datasource.SharePreferenceDatastore;
import com.namlh.sandocu.domain.executor.PostExecutionThread;
import com.namlh.sandocu.domain.executor.ThreadExecutor;
import com.namlh.sandocu.domain.reponsitory.PreferenceRepository;
import com.namlh.sandocu.domain.reponsitory.ResultsRepository;
import com.namlh.sandocu.domain.reponsitory.SQLiteRepository;
import com.namlh.sandocu.presentation.MainApplication;
import com.namlh.sandocu.presentation.UIThread;
import com.namlh.sandocu.presentation.navigator.INavigators;
import com.namlh.sandocu.presentation.navigator.Navigators;
import com.namlh.sandocu.presentation.view.misc.HunterAlarmManager;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by namlh on 01/08/2015.
 */
@Module
public class ApplicationModule {

    private final MainApplication application;

    public ApplicationModule(MainApplication application){
        this.application = application;
    }

    @Provides @Singleton
    public Bus provideBus(){
        return new Bus(ThreadEnforcer.MAIN);
    }

    @Provides @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides @Singleton
    public INavigators provideNavigator(){
        return new Navigators();
    }

    @Provides
    @Singleton
    public ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    public PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    public ResultsRepository provideResultRepository(ResultsDatastore dataStore) {
        return new DataResultsRepository(dataStore);
    }
    @Provides
    @Singleton
    public PreferenceRepository providePreferenceRepository(SharePreferenceDatastore datastore){
        return new DataPreferenceRepository(datastore);
    }

    @Provides
    @Singleton
    public HunterAlarmManager provideHunterAlarmManager(){
        return new HunterAlarmManager(application);
    }

    @Provides
    @Singleton
    public SQLiteDatabase privideSQLiteDatabase(){
        return new DaoMaster.DevOpenHelper(application,"sandocu",null).getWritableDatabase();
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences(){
        return application.getSharedPreferences("sandocu_pref", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    public SQLiteRepository provideSQLiteRepository(SQLiteDatabase db){
        return new DataSQLiteRepository(db);
    }
}
