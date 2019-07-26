package com.example.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.WeChatAdapter;
import com.example.myapplication.adapter.ZhiHuSectionAdapter;
import com.example.myapplication.base.BaseMvpInitPreFragment;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.SectionListBean;
import com.example.myapplication.mvp.section.SectionPresenter;
import com.example.myapplication.mvp.section.SectionView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * MVP抽取
 */
public class ZhihuSectionFragment extends BaseMvpInitPreFragment<SectionPresenter> implements SectionView {


    @BindView(R.id.recycler_section)
    RecyclerView recyclerSection;
    Unbinder unbinder;
    private ZhiHuSectionAdapter zhiHuSectionAdapter;

    //初始化p层
    @Override
    protected SectionPresenter initPresenter() {
        return new SectionPresenter(this);
    }

    @Override
    protected void initView() {
        recyclerSection.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        zhiHuSectionAdapter = new ZhiHuSectionAdapter(getContext());
        recyclerSection.setAdapter(zhiHuSectionAdapter);

        //调用p层方法
        presenter.getSectionList();

    }

    //初始化布局
    @Override
    protected int initLayout() {
        return R.layout.fragment_zhihu_section;
    }

    //实现接口的方法，数据传给适配器
    @Override
    public void getDaily(SectionListBean sectionListBean) {
        List<SectionListBean.DataBean> data = sectionListBean.getData();
        zhiHuSectionAdapter.getSection(data);
    }

    @Override
    public void getError(String error) {

    }

}
