package com.namlh.sandocu.presentation.view.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import com.namlh.sandocu.R;
import com.namlh.sandocu.domain.reponsitory.PreferenceRepository;
import com.namlh.sandocu.presentation.internal.HasComponent;
import com.namlh.sandocu.presentation.internal.component.DaggerSearchComponent;
import com.namlh.sandocu.presentation.internal.component.SearchComponent;
import com.namlh.sandocu.presentation.internal.module.SearchModule;
import com.namlh.sandocu.presentation.view.service.FinderIntentService;

import javax.inject.Inject;

import butterknife.OnClick;

/**
 * Created by namlh on 02/08/2015.
 */
public class ListResultActivity extends BaseActivity implements HasComponent<SearchComponent> {

    private static final String KEYWORD = "key_word";
    private SearchComponent searchComponent;

    @Inject
    PreferenceRepository preferenceRepository;
    private String keyword;
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;

    public static Intent getCallingIntent(Context context, String keyword) {
        Intent intent = new Intent(context, ListResultActivity.class);
        intent.putExtra(KEYWORD, keyword);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_result);
        keyword = getIntent().getStringExtra(KEYWORD);
        this.searchComponent = DaggerSearchComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .searchModule(new SearchModule(keyword))
                .build();
        searchComponent.inject(this);
    }

    @Override
    public SearchComponent getComponent() {
        return searchComponent;
    }


    @OnClick(R.id.btn_sanhang)
    void clickSanHang(){
        preferenceRepository.saveKeyword(keyword);

        alarmMgr = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, FinderIntentService.class);
        alarmIntent = PendingIntent.getService(this, 0, intent, 0);

        alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() +
                        1000 * 60, alarmIntent);
//        FinderIntentService.startAction(this);
    }
}
