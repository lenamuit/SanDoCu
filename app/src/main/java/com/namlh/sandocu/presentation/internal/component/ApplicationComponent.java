package com.namlh.sandocu.presentation.internal.component;

import com.namlh.sandocu.presentation.internal.module.ApplicationModule;
import com.namlh.sandocu.presentation.navigator.INavigators;
import com.namlh.sandocu.presentation.view.activity.BaseActivity;
import com.namlh.sandocu.presentation.view.fragment.BaseFragment;
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