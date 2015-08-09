package com.namlh.sandocu.presentation.view.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import com.namlh.sandocu.R;
import com.namlh.sandocu.presentation.MainApplication;
import com.namlh.sandocu.presentation.internal.component.DaggerHunterComponent;
import com.namlh.sandocu.presentation.internal.component.HunterComponent;
import com.namlh.sandocu.presentation.internal.module.HunterModule;
import com.namlh.sandocu.presentation.model.HunterResultModel;
import com.namlh.sandocu.presentation.presenter.HunterPresenter;
import com.namlh.sandocu.presentation.view.HunterServiceView;

import javax.inject.Inject;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class HunterIntentService extends Service implements HunterServiceView {

    @Inject
    HunterPresenter presenter;

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    public static void startAction(Context context) {
        Intent intent = new Intent(context, HunterIntentService.class);
        context.startService(intent);
    }

    public HunterIntentService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        HunterComponent component = DaggerHunterComponent.builder()
                .applicationComponent(MainApplication.get(this).getApplicationComponent())
                .hunterModule(new HunterModule())
                .build();
        component.inject(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        presenter.setHunterServiceView(this);
        presenter.findNewestResult();
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Test service")
                .setContentText("test service....")
                .setDefaults(Notification.DEFAULT_ALL)
                .build();
        NotificationManager notificationManagerCompat = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManagerCompat.notify(1, notification);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void showNotification(HunterResultModel model) {
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(model.title)
                .setContentText(model.description)
                .setDefaults(Notification.DEFAULT_ALL)
                .build();
        NotificationManager notificationManagerCompat = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManagerCompat.notify((int) model.id,notification);
    }

    @Override
    public void onCompleted() {
        this.stopSelf();
    }
}
