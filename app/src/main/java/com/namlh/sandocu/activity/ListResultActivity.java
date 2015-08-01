package com.namlh.sandocu.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.namlh.sandocu.R;
import com.namlh.sandocu.otto.OnTestBus;
import com.squareup.otto.Subscribe;

/**
 * Created by namlh on 02/08/2015.
 */
public class ListResultActivity extends BaseActivity {

    private static final String KEYWORD = "key_word";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_result);
    }

    @Subscribe
    public void onTestBus(OnTestBus test){
        Toast.makeText(this,"Test Bus",Toast.LENGTH_LONG).show();
    }

    public static Intent getCallingIntent(Context context, String keyword) {
        Intent intent = new Intent(context,ListResultActivity.class);
        intent.putExtra(KEYWORD, keyword);
        return intent;
    }
}
