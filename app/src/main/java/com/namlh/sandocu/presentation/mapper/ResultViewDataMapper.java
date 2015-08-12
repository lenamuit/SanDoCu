package com.namlh.sandocu.presentation.mapper;

import com.namlh.sandocu.domain.ResultItem;
import com.namlh.sandocu.presentation.internal.annotation.PerActivity;
import com.namlh.sandocu.presentation.model.ResultViewModel;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

/**
 * Created by namlh on 06/08/2015.
 */
@PerActivity
public class ResultViewDataMapper {
    @Inject
    public ResultViewDataMapper() {
    }

    public ResultViewModel transform(ResultItem resultItem) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(resultItem.getTimeInMillisecond());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:ss");
        String dateTime = formatter.format(calendar.getTime());
        DecimalFormat format = new DecimalFormat("#,### VND");
        String price = format.format(resultItem.getPrice());
        return new ResultViewModel(
                resultItem.getTitle(),
                price,
                dateTime,
                resultItem.getLocation(),
                resultItem.getLink(),
                resultItem.getImageUrl());
    }
}
