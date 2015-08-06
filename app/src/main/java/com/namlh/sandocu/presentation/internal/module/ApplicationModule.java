package com.namlh.sandocu.presentation.internal.module;

import android.content.Context;

import com.namlh.sandocu.data.excutor.JobExecutor;
import com.namlh.sandocu.data.reponsitory.DataResultsRepository;
import com.namlh.sandocu.data.reponsitory.datasource.ResultsDatastore;
import com.namlh.sandocu.domain.executor.PostExecutionThread;
import com.namlh.sandocu.domain.executor.ThreadExecutor;
import com.namlh.sandocu.domain.reponsitory.ResultsRepository;
import com.namlh.sandocu.presentation.MainApplication;
import com.namlh.sandocu.presentation.UIThread;
import com.namlh.sandocu.presentation.navigator.INavigators;
import com.namlh.sandocu.presentation.navigator.Navigators;
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
}
