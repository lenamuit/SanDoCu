package com.namlh.sandocu.presentation.internal.module;

import com.namlh.sandocu.data.reponsitory.JobExecutor;
import com.namlh.sandocu.domain.executor.PostExecutionThread;
import com.namlh.sandocu.domain.executor.ThreadExecutor;
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
    public MainApplication provideApplication(){
        return application;
    }

    @Provides @Singleton
    public INavigators provideNavigator(){
        return new Navigators();
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }
}
