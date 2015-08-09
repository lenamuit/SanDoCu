package com.namlh.sandocu.presentation.presenter;

import com.namlh.sandocu.domain.ResultItem;
import com.namlh.sandocu.domain.interactor.UseCase;
import com.namlh.sandocu.presentation.internal.annotation.PerService;
import com.namlh.sandocu.presentation.mapper.HunterResultViewDataMapper;
import com.namlh.sandocu.presentation.view.HunterServiceView;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by namlh on 08/08/2015.
 */
@PerService
public class HunterPresenter extends Subscriber<ResultItem> implements Presenter{

    private final UseCase<ResultItem> useCase;
    private final HunterResultViewDataMapper mapper;
    private HunterServiceView hunterServiceView;

    @Inject
    public HunterPresenter(UseCase<ResultItem> useCase,
                           HunterResultViewDataMapper mapper){
        this.useCase = useCase;
        this.mapper = mapper;
    }

    public void setHunterServiceView(HunterServiceView hunterServiceView){
        this.hunterServiceView = hunterServiceView;
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
        hunterServiceView.onCompleted();
    }

    @Override
    public void onError(Throwable e) {
        hunterServiceView.onCompleted();
    }

    @Override
    public void onNext(ResultItem resultItem) {
        hunterServiceView.showNotification(mapper.transform(resultItem));
    }
}
