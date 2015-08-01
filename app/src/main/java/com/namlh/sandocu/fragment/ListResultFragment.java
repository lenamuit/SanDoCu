package com.namlh.sandocu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.namlh.sandocu.R;
import com.namlh.sandocu.otto.OnTestBus;

import butterknife.OnClick;

/**
 * Created by namlh on 02/08/2015.
 */
public class ListResultFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_result,container,false);
    }

    @OnClick(R.id.btn_test_bus)
    void testBus(){
        mBus.post(new OnTestBus());
    }
}
