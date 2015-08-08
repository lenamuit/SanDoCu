package com.namlh.sandocu.presentation.view;

import com.namlh.sandocu.presentation.model.FinderResultModel;

/**
 * Created by namlh on 08/08/2015.
 */
public interface FinderServiceView {
    void showNotification(FinderResultModel model);
    void onCompleted();
}
