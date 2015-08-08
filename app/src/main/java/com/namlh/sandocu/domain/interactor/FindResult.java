package com.namlh.sandocu.domain.interactor;

import com.namlh.sandocu.domain.ResultItem;
import com.namlh.sandocu.domain.executor.PostExecutionThread;
import com.namlh.sandocu.domain.executor.ThreadExecutor;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by namlh on 08/08/2015.
 */
@Singleton
@Named("FindResult")
public class FindResult extends UseCase<ResultItem> {
    @Inject
    public FindResult(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
    }

    @Override
    protected Observable<ResultItem> buildUseCaseObservable() {
        ResultItem test = new ResultItem();
        test.setTitle("test item");
        test.setLocation("HCM");
        test.setTimeInMillisecond(System.currentTimeMillis());
        test.setLink("http://google.com");
        return Observable.from(new ResultItem[]{ test });
    }
}
