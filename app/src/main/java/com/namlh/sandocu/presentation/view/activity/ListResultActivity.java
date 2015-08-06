package com.namlh.sandocu.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.namlh.sandocu.R;
import com.namlh.sandocu.presentation.internal.HasComponent;
import com.namlh.sandocu.presentation.internal.component.DaggerSearchComponent;
import com.namlh.sandocu.presentation.internal.component.SearchComponent;
import com.namlh.sandocu.presentation.internal.module.SearchModule;
import com.namlh.sandocu.presentation.otto.OnTestBus;
import com.squareup.otto.Subscribe;

/**
 * Created by namlh on 02/08/2015.
 */
public class ListResultActivity extends BaseActivity implements HasComponent<SearchComponent> {

    private static final String KEYWORD = "key_word";
    private String keyword;

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
    }

    @Subscribe
    public void onTestBus(OnTestBus test){
        Toast.makeText(this,"Test Bus",Toast.LENGTH_LONG).show();
    }

    @Override
    public SearchComponent getComponent() {
        return DaggerSearchComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .searchModule(new SearchModule(keyword))
                .build();
    }


}
