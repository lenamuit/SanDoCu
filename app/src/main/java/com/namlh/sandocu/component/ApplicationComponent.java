package com.namlh.sandocu.component;

import android.app.Activity;
import android.os.Handler;

import com.namlh.sandocu.activity.BaseActivity;
import com.namlh.sandocu.fragment.BaseFragment;
import com.namlh.sandocu.module.ApplicationModule;
import com.namlh.sandocu.navigator.INavigators;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by namlh on 01/08/2015.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity activity);
    void inject(BaseFragment activity);
    Bus bus();
    INavigators navigator();
}
