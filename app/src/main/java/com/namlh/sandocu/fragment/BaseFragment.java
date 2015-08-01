package com.namlh.sandocu.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.namlh.sandocu.MainApplication;
import com.namlh.sandocu.activity.BaseActivity;
import com.namlh.sandocu.component.ApplicationComponent;
import com.namlh.sandocu.internal.HasComponent;
import com.namlh.sandocu.navigator.INavigators;
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
