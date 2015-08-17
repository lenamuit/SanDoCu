package com.namlh.sandocu.domain.interactor;

import com.namlh.sandocu.domain.ResultItem;
import com.namlh.sandocu.domain.executor.PostExecutionThread;
import com.namlh.sandocu.domain.executor.ThreadExecutor;
import com.namlh.sandocu.domain.reponsitory.PreferenceRepository;
import com.namlh.sandocu.domain.reponsitory.ResultsRepository;
import com.namlh.sandocu.domain.reponsitory.SQLiteRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by namlh on 08/08/2015.
 */
@Singleton
@Named("FindResult")
public class HuntResult extends UseCase<ResultItem> {
    private final PreferenceRepository preference;
    private final ResultsRepository resultRepository;
    private final SQLiteRepository sqliteRepository;

    @Inject
    public HuntResult(ResultsRepository resultsRepository,
                      ThreadExecutor threadExecutor,
                      PostExecutionThread postExecutionThread,
                      PreferenceRepository preferenceRepository,
                      SQLiteRepository sqliteRepository) {
        super(threadExecutor, postExecutionThread);
        this.preference = preferenceRepository;
        this.resultRepository = resultsRepository;
        this.sqliteRepository = sqliteRepository;
    }

    @Override
    protected Observable<ResultItem> buildUseCaseObservable() {
        return resultRepository.getResults(preference.getKeyword())
                .flatMap(Observable::<ResultItem>from)
                .filter(resultItem -> resultItem.getTimeInMillisecond() > preference.getLastestUpdateTime())
                .doOnEach(notification -> sqliteRepository.saveResultItem((ResultItem) notification.getValue()))
                .doOnCompleted(() -> preference.saveLastedUpdateTime(System.currentTimeMillis()));
    }
}
