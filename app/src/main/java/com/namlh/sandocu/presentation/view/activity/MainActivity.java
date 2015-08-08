package com.namlh.sandocu.presentation.view.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.namlh.sandocu.R;

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
