package com.example.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.adapter.GankCommendAdapter;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.base.BaseMvpInitPreFragment;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.GankBean;
import com.example.myapplication.mvp.gank.GankPresenter;
import com.example.myapplication.mvp.gank.GankView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GankCommendFragment extends BaseMvpInitPreFragment<GankPresenter> implements GankView {


    @BindView(R.id.img_gank_top)
    ImageView imgGankTop;
    @BindView(R.id.title_gank_top)
    TextView titleGankTop;
    @BindView(R.id.view_main)
    RecyclerView viewMain;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swip;
    Unbinder unbinder;
    private GankCommendAdapter gankCommendAdapter;

    @Override
    protected GankPresenter initPresenter() {
        return new GankPresenter(this);
    }

    @Override
    protected void initView() {
        String url="http://ww1.sinaimg.cn/large/0065oQSqly1g2pquqlp0nj30n00yiq8u.jpg";
        Glide.with(getActivity()).load(url).into(imgGankTop);
        titleGankTop.setText("这是个啥");

        viewMain.setLayoutManager(new LinearLayoutManager(getActivity()));
        gankCommendAdapter = new GankCommendAdapter(getActivity());
        viewMain.setAdapter(gankCommendAdapter);

        //多个Fragment共用，布局效果一样
        Bundle bundle = getArguments();
        String path = bundle.getString("path");

        presenter.getGankList(path);
    }

    @Override
    protected int initLayout() {
        return R.layout.gank__fragment;
    }

    @Override
    public void getGankConmmend(GankBean gankBean) {
        List<GankBean.ResultsBean> results = gankBean.getResults();
        gankCommendAdapter.getGankList(results);
    }

    private static final String TAG = "tag";
    @Override
    public void getError(String error) {
        Log.d(TAG, "getError: ==gank="+error);
    }
}
