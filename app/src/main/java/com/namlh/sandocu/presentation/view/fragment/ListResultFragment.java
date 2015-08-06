package com.namlh.sandocu.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.namlh.sandocu.R;
import com.namlh.sandocu.presentation.internal.HasComponent;
import com.namlh.sandocu.presentation.internal.component.SearchComponent;
import com.namlh.sandocu.presentation.model.ResultViewModel;
import com.namlh.sandocu.presentation.presenter.ResultsPresenter;
import com.namlh.sandocu.presentation.view.ResultsView;

import java.util.Collection;

import javax.inject.Inject;

/**
 * Created by namlh on 02/08/2015.
 */
public class ListResultFragment extends BaseFragment implements ResultsView {

    private static final String KEYWORD = "key_word";
    @Inject
    ResultsPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializes();
        presenter.getResults();
    }

    @SuppressWarnings("unchecked")
    private void initializes() {
        ((HasComponent<SearchComponent>) getActivity()).getComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_result,container,false);
    }

    @Override
    public void renderData(Collection<ResultViewModel> data) {
        for (ResultViewModel model : data) {
            Log.e("Result:", model.toString());
        }
    }

    @Override
    public void viewDetail(ResultViewModel resultViewModel) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context getContext() {
        return null;
    }
}
