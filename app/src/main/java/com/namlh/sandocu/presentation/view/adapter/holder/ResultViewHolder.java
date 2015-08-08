package com.namlh.sandocu.presentation.view.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.namlh.sandocu.R;
import com.namlh.sandocu.presentation.model.ResultViewModel;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by namlh on 07/08/2015.
 */
public class ResultViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_time)
    TextView tvTime;

    public ResultViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bindData(ResultViewModel model){
        tvTitle.setText(model.title);
        tvTime.setText(model.dateTime);
    }
}
