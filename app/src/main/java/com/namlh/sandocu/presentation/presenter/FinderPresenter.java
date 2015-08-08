package com.namlh.sandocu.presentation.presenter;

import com.namlh.sandocu.domain.ResultItem;
import com.namlh.sandocu.domain.interactor.UseCase;
import com.namlh.sandocu.presentation.internal.annotation.PerService;
import com.namlh.sandocu.presentation.mapper.FinderResultViewDataMapper;
import com.namlh.sandocu.presentation.view.FinderServiceView;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by namlh on 08/08/2015.
 */
@PerService
public class FinderPresenter extends Subscriber<ResultItem> implements Presenter{

    private final UseCase<ResultItem> useCase;
    private final FinderResultViewDataMapper mapper;
    private FinderServiceView finderServiceView;

    @Inject
    public FinderPresenter(UseCase<ResultItem> useCase,FinderResultViewDataMapper mapper){
        this.useCase = useCase;
        this.mapper = mapper;
    }

    public void setFinderServiceView(FinderServiceView finderServiceView){
        this.finderServiceView = finderServiceView;
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

    public void findNewestResult(){
        useCase.execute(this);
    }

    @Override
    public void onCompleted() {
        finderServiceView.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        finderServiceView.onCompleted();
    }

    @Override
    public void onNext(ResultItem resultItem) {
        finderServiceView.showNotification(mapper.transform(resultItem));
    }
}
