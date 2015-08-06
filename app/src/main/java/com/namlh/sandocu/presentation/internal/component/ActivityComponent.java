package com.namlh.sandocu.presentation.internal.component;

import android.app.Activity;

import com.namlh.sandocu.presentation.internal.annotation.PerActivity;
import com.namlh.sandocu.presentation.internal.module.ActivityModule;

import dagger.Component;

/**
 * Created by namlh on 06/08/2015.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
