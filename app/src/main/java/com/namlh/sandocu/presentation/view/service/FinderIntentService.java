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
import com.namlh.sandocu.presentation.internal.component.DaggerFindNewestComponent;
import com.namlh.sandocu.presentation.internal.component.FindNewestComponent;
import com.namlh.sandocu.presentation.internal.module.FindNewestModule;
import com.namlh.sandocu.presentation.model.FinderResultModel;
import com.namlh.sandocu.presentation.presenter.FinderPresenter;
import com.namlh.sandocu.presentation.view.FinderServiceView;

import javax.inject.Inject;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class FinderIntentService extends Service implements FinderServiceView {

    @Inject
    FinderPresenter presenter;

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    public static void startAction(Context context) {
        Intent intent = new Intent(context, FinderIntentService.class);
        context.startService(intent);
    }

    public FinderIntentService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        FindNewestComponent component = DaggerFindNewestComponent.builder()
                .applicationComponent(MainApplication.get(this).getApplicationComponent())
                .findNewestModule(new FindNewestModule())
                .build();
        component.inject(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        presenter.setFinderServiceView(this);
        presenter.findNewestResult();
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
    public void showNotification(FinderResultModel model) {
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(model.title)
                .setContentText(model.description)
                .build();
        NotificationManager notificationManagerCompat = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManagerCompat.notify((int) model.id,notification);
    }

    @Override
    public void onCompleted() {
        this.stopSelf();
    }
}
