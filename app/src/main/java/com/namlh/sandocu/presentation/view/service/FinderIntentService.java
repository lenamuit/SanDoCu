package com.namlh.sandocu.presentation.view.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

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
public class FinderIntentService extends IntentService implements FinderServiceView {

    @Inject
    FinderPresenter presenter;

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startAction(Context context) {
        Intent intent = new Intent(context, FinderIntentService.class);
        context.startService(intent);
    }


    public FinderIntentService() {
        super("FinderIntentService");
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
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            presenter.setFinderServiceView(this);
            presenter.findNewestResult();
        }
    }

    @Override
    public void showNotification(FinderResultModel model) {
        Toast.makeText(this,model.description,Toast.LENGTH_LONG).show();
    }
}
