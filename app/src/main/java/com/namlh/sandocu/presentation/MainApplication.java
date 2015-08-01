package com.namlh.sandocu.presentation;

import android.app.Application;

import com.namlh.sandocu.presentation.internal.component.ApplicationComponent;
import com.namlh.sandocu.presentation.internal.component.DaggerApplicationComponent;
import com.namlh.sandocu.presentation.internal.module.ApplicationModule;

/**
 * Created by namlh on 01/08/2015.
 */
public class MainApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initInjector();
    }

    private void initInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}