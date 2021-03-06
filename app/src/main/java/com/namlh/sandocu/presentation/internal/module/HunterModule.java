package com.namlh.sandocu.presentation.internal.module;

import com.namlh.sandocu.domain.ResultItem;
import com.namlh.sandocu.domain.executor.PostExecutionThread;
import com.namlh.sandocu.domain.executor.ThreadExecutor;
import com.namlh.sandocu.domain.interactor.HuntResult;
import com.namlh.sandocu.domain.interactor.UseCase;
import com.namlh.sandocu.domain.reponsitory.PreferenceRepository;
import com.namlh.sandocu.domain.reponsitory.ResultsRepository;
import com.namlh.sandocu.domain.reponsitory.SQLiteRepository;
import com.namlh.sandocu.presentation.internal.annotation.PerService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by namlh on 08/08/2015.
 */
@Module
public class HunterModule {

    @Provides
    @PerService
    public UseCase<ResultItem> provideFinderUsecase(ThreadExecutor threadExecutor,
                                                    PostExecutionThread postExecution,
                                                    PreferenceRepository preference,
                                                    ResultsRepository resultRepository,
                                                    SQLiteRepository sqliteRepository){
        return new HuntResult(resultRepository,threadExecutor,postExecution,preference,sqliteRepository);
    }
}
