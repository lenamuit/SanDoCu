package com.namlh.sandocu.presentation.presenter;

import com.namlh.sandocu.domain.ResultItem;
import com.namlh.sandocu.domain.interactor.UseCase;
import com.namlh.sandocu.presentation.internal.annotation.PerActivity;
import com.namlh.sandocu.presentation.mapper.ResultViewDataMapper;
import com.namlh.sandocu.presentation.model.ResultViewModel;
import com.namlh.sandocu.presentation.view.ResultsView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by namlh on 03/08/2015.
 */
@PerActivity
public class ResultsPresenter extends Subscriber<List<ResultItem>> implements Presenter {

    private final UseCase<List<ResultItem>> useCase;
    private final ResultViewDataMapper mapper;
    private ResultsView resultsView;

    @Inject
    public ResultsPresenter(UseCase<List<ResultItem>> resultUsecase, ResultViewDataMapper mapper) {
        this.useCase = resultUsecase;
        this.mapper = mapper;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        useCase.unsubscribe();
    }

    public void getResults() {
        useCase.execute(this);
    }

    public void setResultsView(ResultsView view) {
        this.resultsView = view;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(List<ResultItem> resultItem) {
        Collection<ResultViewModel> data = new ArrayList<>();
        for (ResultItem item : resultItem) {
            data.add(mapper.transform(item));
        }
        resultsView.renderData(data);
    }
}
