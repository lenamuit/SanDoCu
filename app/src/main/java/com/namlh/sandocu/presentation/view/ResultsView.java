package com.namlh.sandocu.presentation.view;

import com.namlh.sandocu.presentation.model.ResultViewModel;

import java.util.Collection;

/**
 * Created by namlh on 03/08/2015.
 */
public interface ResultsView extends LoadDataView {

    void renderData(Collection<ResultViewModel> data);

    void viewDetail(ResultViewModel resultViewModel);

    void startAlarmService();

    void stopAlarmService();

}
