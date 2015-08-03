package com.namlh.sandocu.domain.interactor;

import com.namlh.sandocu.domain.executor.PostExecutionThread;
import com.namlh.sandocu.domain.executor.ThreadExecutor;

import rx.Observable;

/**
 * Created by namlh on 03/08/2015.
 */
public class GetListResult extends UseCase {

    protected GetListResult(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);

    }

    @Override
    protected Observable buildUseCaseObservable() {
        return null;
    }
}
