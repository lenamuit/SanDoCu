package com.namlh.sandocu.presentation.presenter;

import com.namlh.sandocu.presentation.internal.annotation.PerActivity;
import com.namlh.sandocu.presentation.view.ResultsView;

import javax.inject.Inject;

/**
 * Created by namlh on 03/08/2015.
 */
@PerActivity
public class ResultsPresenter implements Presenter {

    private ResultsView resultsView;

    @Inject
    public ResultsPresenter() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    public void getResults(String keyword) {

    }

    public void setResultsView(ResultsView view) {
        this.resultsView = view;
    }
}
