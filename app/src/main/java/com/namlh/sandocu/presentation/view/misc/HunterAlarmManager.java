package com.namlh.sandocu.presentation.view.misc;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.namlh.sandocu.presentation.view.service.HunterIntentService;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by namlh on 09/08/2015.
 */
@Singleton
public class HunterAlarmManager {

    private final AlarmManager alarmMgr;
    private final PendingIntent alarmIntent;

    @Inject
    public HunterAlarmManager(Context context){
        alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, HunterIntentService.class);
        alarmIntent = PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    public void startAlarm(){
        alarmMgr.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                AlarmManager.INTERVAL_HALF_HOUR,
                AlarmManager.INTERVAL_HALF_HOUR, alarmIntent);
    }

    public void stopAlarm(){
        alarmMgr.cancel(alarmIntent);
    }
}
