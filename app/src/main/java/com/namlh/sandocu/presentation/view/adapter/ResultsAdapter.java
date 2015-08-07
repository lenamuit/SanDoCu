package com.namlh.sandocu.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.namlh.sandocu.R;
import com.namlh.sandocu.presentation.model.ResultViewModel;
import com.namlh.sandocu.presentation.view.adapter.holder.ResultViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by namlh on 07/08/2015.
 */
public class ResultsAdapter extends RecyclerView.Adapter<ResultViewHolder> {

    private final Context context;

    private final List<ResultViewModel> data = new ArrayList<>();

    public ResultsAdapter(Context context){
        this.context = context;
    }

    @Override
    public ResultViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_result,null);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ResultViewHolder resultViewHolder, int i) {
        resultViewHolder.bindData(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addItems(Collection<ResultViewModel> items){
        data.addAll(items);
        notifyDataSetChanged();
    }
}
