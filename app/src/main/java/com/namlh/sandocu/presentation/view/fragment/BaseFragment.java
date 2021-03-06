package com.namlh.sandocu.presentation.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.namlh.sandocu.presentation.MainApplication;
import com.namlh.sandocu.presentation.internal.component.ApplicationComponent;
import com.namlh.sandocu.presentation.navigator.INavigators;
import com.namlh.sandocu.presentation.view.activity.BaseActivity;
import com.namlh.sandocu.presentation.view.misc.HunterAlarmManager;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by namlh on 02/08/2015.
 */
public abstract class BaseFragment extends Fragment {

    protected BaseActivity baseActivity;

    @Inject
    Bus mBus;
    @Inject
    INavigators navigators;
    @Inject
    HunterAlarmManager alarmManager;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.baseActivity = (BaseActivity) activity;
        getApplicationComponent().inject(this);
        mBus.register(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        mBus.unregister(this);
    }

    protected ApplicationComponent getApplicationComponent(){
        return ((MainApplication) baseActivity.getApplication()).getApplicationComponent();
    }

}
