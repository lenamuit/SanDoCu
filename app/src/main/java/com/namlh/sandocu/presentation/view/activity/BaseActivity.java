package com.namlh.sandocu.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.namlh.sandocu.presentation.MainApplication;
import com.namlh.sandocu.presentation.internal.component.ApplicationComponent;
import com.namlh.sandocu.presentation.internal.module.ActivityModule;
import com.namlh.sandocu.presentation.navigator.INavigators;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by namlh on 01/08/2015.
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Inject
    Bus mBus;
    @Inject
    INavigators navigators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplicationComponent().inject(this);
        mBus.register(this);
    }

    @Override
    protected void onStop() {
        mBus.unregister(this);
        super.onStop();
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    protected ApplicationComponent getApplicationComponent(){
        return ((MainApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
