package com.namlh.sandocu.presentation.view;

import com.namlh.sandocu.presentation.model.HunterResultModel;

/**
 * Created by namlh on 08/08/2015.
 */
public interface HunterServiceView {
    void showNotification(HunterResultModel model);
    void onCompleted();
}
