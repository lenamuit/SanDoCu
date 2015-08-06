package com.namlh.sandocu.presentation.internal.module;

import android.app.Activity;

import com.namlh.sandocu.presentation.internal.annotation.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by namlh on 06/08/2015.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity() {
        return activity;
    }
}
