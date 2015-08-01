package com.namlh.sandocu.module;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.namlh.sandocu.MainApplication;
import com.namlh.sandocu.UIHandler;
import com.namlh.sandocu.navigator.INavigators;
import com.namlh.sandocu.navigator.Navigators;
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
}
