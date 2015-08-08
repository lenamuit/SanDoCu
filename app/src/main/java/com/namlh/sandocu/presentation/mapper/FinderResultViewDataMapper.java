package com.namlh.sandocu.presentation.mapper;

import com.namlh.sandocu.domain.ResultItem;
import com.namlh.sandocu.presentation.internal.annotation.PerService;
import com.namlh.sandocu.presentation.model.FinderResultModel;

import javax.inject.Inject;

/**
 * Created by namlh on 08/08/2015.
 */
@PerService
public class FinderResultViewDataMapper {
    @Inject
    public FinderResultViewDataMapper(){}

    public FinderResultModel transform(ResultItem item){
        String title = item.getTitle();
        String description = String.format("Description: %s, at %s",item.getTitle(),item.getLocation());
        return new FinderResultModel(title,description,item.getLink(), item.getId());
    }

}
