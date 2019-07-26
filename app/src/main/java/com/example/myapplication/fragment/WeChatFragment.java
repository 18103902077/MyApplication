package com.example.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.WeChatAdapter;
import com.example.myapplication.adapter.ZhiHuAdapter;
import com.example.myapplication.adapter.ZhiHuHotAdapter;
import com.example.myapplication.base.BaseMvpInitPreFragment;
import com.example.myapplication.bean.WeChatBean;
import com.example.myapplication.mvp.wechat.WeChatPresenter;
import com.example.myapplication.mvp.wechat.WechatView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeChatFragment extends BaseMvpInitPreFragment<WeChatPresenter> implements WechatView {


    @BindView(R.id.recycler_wechat)
    RecyclerView recyclerWechat;
    private WeChatAdapter weChatAdapter;

    @Override
    protected WeChatPresenter initPresenter() {
        return new WeChatPresenter(this);
    }

    @Override
    protected void initView() {
        recyclerWechat.setLayoutManager(new LinearLayoutManager(getContext()));
        weChatAdapter = new WeChatAdapter(getContext());
        recyclerWechat.setAdapter(weChatAdapter);

        presenter.getWeChatList();
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_we_chat;
    }

    @Override
    public void getDaily(WeChatBean weChatBean) {
        weChatAdapter.getHot(weChatBean.getNewslist());
    }

    @Override
    public void getError(String error) {

    }

}
