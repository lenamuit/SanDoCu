package com.namlh.sandocu.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.namlh.sandocu.R;
import com.namlh.sandocu.presentation.internal.HasComponent;
import com.namlh.sandocu.presentation.internal.component.SearchComponent;
import com.namlh.sandocu.presentation.model.ResultViewModel;
import com.namlh.sandocu.presentation.presenter.ResultsPresenter;
import com.namlh.sandocu.presentation.view.ResultsView;
import com.namlh.sandocu.presentation.view.adapter.ResultsAdapter;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by namlh on 02/08/2015.
 */
public class ListResultFragment extends BaseFragment implements ResultsView {

    private static final String KEYWORD = "key_word";
    @Inject
    ResultsPresenter presenter;

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    @Bind(R.id.btn_sanhang)
    TextView btnSanhang;

    private ResultsAdapter adapter;
    private String keyword;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializes();
        presenter.getResults();
    }

    @SuppressWarnings("unchecked")
    private void initializes() {
        SearchComponent searchComponent = ((HasComponent<SearchComponent>) getActivity()).getComponent();
        searchComponent.inject(this);
        keyword = searchComponent.keyword();
        presenter.setResultsView(this);
        if (presenter.isHunting(keyword))
            btnSanhang.setText("Bạn đang săn món này");
        else
            btnSanhang.setText("Săn món này");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_result,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new ResultsAdapter(baseActivity);
        recyclerView.setLayoutManager(new GridLayoutManager(baseActivity,1));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void renderData(Collection<ResultViewModel> data) {
        adapter.addItems(data);
    }

    @Override
    public void viewDetail(ResultViewModel resultViewModel) {

    }

    @Override
    public void startAlarmService() {
        alarmManager.startAlarm();
    }

    @Override
    public void stopAlarmService() {
        alarmManager.stopAlarm();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @OnClick(R.id.btn_sanhang)
    void huntThisProduct(){
        if (presenter.isHunting(keyword)){
            presenter.unHuntKeyword(keyword);
            btnSanhang.setText("Săn món này");
        }
        else {
            presenter.huntKeyword(keyword);
            btnSanhang.setText("Bạn đang săn món này");
        }
    }
}
