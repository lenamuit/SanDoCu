package com.namlh.sandocu.presentation.internal.module;

import com.namlh.sandocu.domain.ResultItem;
import com.namlh.sandocu.domain.executor.PostExecutionThread;
import com.namlh.sandocu.domain.executor.ThreadExecutor;
import com.namlh.sandocu.domain.interactor.GetResults;
import com.namlh.sandocu.domain.interactor.UseCase;
import com.namlh.sandocu.domain.reponsitory.ResultsRepository;
import com.namlh.sandocu.presentation.internal.annotation.PerActivity;

import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by namlh on 06/08/2015.
 */
@Module
public class SearchModule {

    private final String keyword;

    public SearchModule(String keyword) {
        this.keyword = keyword;
    }

    @Provides
    @PerActivity
    public UseCase<List<ResultItem>> provideResultItemUseCase(ResultsRepository reponsitory, ThreadExecutor threadExexutor, PostExecutionThread postThreadExecution) {
        return new GetResults(keyword, reponsitory, threadExexutor, postThreadExecution);
    }

    @Provides
    @PerActivity
    public String provideKeyword(){
        return keyword;
    }
}
