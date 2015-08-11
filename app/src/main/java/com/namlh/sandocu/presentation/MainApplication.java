package com.namlh.sandocu.presentation;

import android.app.Application;
import android.content.Context;

import com.namlh.sandocu.R;
import com.namlh.sandocu.presentation.internal.component.ApplicationComponent;
import com.namlh.sandocu.presentation.internal.component.DaggerApplicationComponent;
import com.namlh.sandocu.presentation.internal.module.ApplicationModule;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by namlh on 01/08/2015.
 */
public class MainApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initInjector();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/Roboto-Medium.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }

    private void initInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }

    public static MainApplication get(Context context){
        return (MainApplication) context.getApplicationContext();
    }
}
