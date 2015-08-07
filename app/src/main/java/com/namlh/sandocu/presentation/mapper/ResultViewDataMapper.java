package com.namlh.sandocu.presentation.mapper;

import com.namlh.sandocu.domain.ResultItem;
import com.namlh.sandocu.presentation.internal.annotation.PerActivity;
import com.namlh.sandocu.presentation.model.ResultViewModel;

import javax.inject.Inject;

/**
 * Created by namlh on 06/08/2015.
 */
@PerActivity
public class ResultViewDataMapper {
    @Inject
    public ResultViewDataMapper() {
    }

    public ResultViewModel tranform(ResultItem resultItem) {
        ResultViewModel model = new ResultViewModel(resultItem.getTitle(), 0, resultItem.getDateTime(), resultItem.getLocation(), resultItem.getLink());
        return model;
    }
}
