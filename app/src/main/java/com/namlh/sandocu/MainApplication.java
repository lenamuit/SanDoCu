package com.namlh.sandocu;

import android.app.Application;

import com.namlh.sandocu.component.ApplicationComponent;
import com.namlh.sandocu.component.DaggerApplicationComponent;
import com.namlh.sandocu.module.ApplicationModule;

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
