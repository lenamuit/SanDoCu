package com.namlh.sandocu.navigator;

import android.content.Context;
import android.content.Intent;

import com.namlh.sandocu.activity.ListResultActivity;

import javax.inject.Inject;

/**
 * Created by namlh on 02/08/2015.
 */
public class Navigators implements INavigators {
    @Override
    public void moveToResultScreen(Context context,String keyword) {
        Intent intent = ListResultActivity.getCallingIntent(context,keyword);
        context.startActivity(intent);
    }
}
