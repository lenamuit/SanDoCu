package com.namlh.sandocu.presentation.view;

import com.namlh.sandocu.presentation.model.ResultObj;

import java.util.Collection;

/**
 * Created by namlh on 03/08/2015.
 */
public interface ResultsView extends LoadDataView {

    void renderData(Collection<ResultObj> data);

    void viewDetail(ResultObj resultObj);

}
