package com.namlh.sandocu;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.squareup.otto.Bus;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by namlh on 01/08/2015.
 */
@Singleton
public class UIHandler extends Handler{
    @Inject
    public UIHandler(final Bus bus){
        super(Looper.getMainLooper(), new Callback() {
            @Override
            public boolean handleMessage(Message message) {
                bus.post(message.obj);
                return true;
            }
        });
    }

    public void sendObjectToUI(Object object){
        Message message = obtainMessage(911,object);
        message.sendToTarget();
    }
}
