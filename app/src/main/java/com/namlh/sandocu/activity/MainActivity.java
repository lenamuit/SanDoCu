package com.namlh.sandocu.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.namlh.sandocu.R;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.et_keyword)
    TextView etKeyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick(R.id.btn_search)
    void doSearch(){
        if (etKeyword.getText().length()>0)
            navigators.moveToResultScreen(this,etKeyword.getText().toString());
    }

}
