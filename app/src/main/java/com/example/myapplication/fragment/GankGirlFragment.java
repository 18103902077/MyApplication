package com.example.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.GankGirlAdapter;
import com.example.myapplication.base.BaseMvpInitPreFragment;
import com.example.myapplication.bean.GankGirlBean;
import com.example.myapplication.mvp.gank.GankGirlPresenter;
import com.example.myapplication.mvp.gank.GankGirlView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GankGirlFragment extends BaseMvpInitPreFragment<GankGirlPresenter> implements GankGirlView {


    @BindView(R.id.recycler_gankGirl)
    RecyclerView recyclerGankGirl;
    Unbinder unbinder;
    private GankGirlAdapter gankGirlAdapter;

    @Override
    protected GankGirlPresenter initPresenter() {
        return new GankGirlPresenter(this);
    }


    @Override
    protected void initView() {
        recyclerGankGirl.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        gankGirlAdapter = new GankGirlAdapter(getContext());
        recyclerGankGirl.setAdapter(gankGirlAdapter);

        presenter.getGankGirlList();

    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_gank_girl;
    }

    @Override
    public void getError(String error) {

    }

    @Override
    public void getGankGirlList(GankGirlBean gankGirlBean) {
        List<GankGirlBean.ResultsBean> girlBeanResults = gankGirlBean.getResults();
        gankGirlAdapter.getGankList(girlBeanResults);
    }


}
