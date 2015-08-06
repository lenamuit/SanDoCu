package com.namlh.sandocu.domain.interactor;

import com.namlh.sandocu.domain.ResultItem;
import com.namlh.sandocu.domain.executor.PostExecutionThread;
import com.namlh.sandocu.domain.executor.ThreadExecutor;
import com.namlh.sandocu.domain.reponsitory.ResultsRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by namlh on 03/08/2015.
 */
@Singleton
public class GetResults extends UseCase<List<ResultItem>> {

    private final ResultsRepository repository;
    private final String keyword;

    @Inject
    public GetResults(String keyword, ResultsRepository resultsRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = resultsRepository;
        this.keyword = keyword;
    }

    @Override
    protected Observable<List<ResultItem>> buildUseCaseObservable() {
        return repository.getResults(keyword);
    }
}
