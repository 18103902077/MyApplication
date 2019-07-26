package com.example.myapplication.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.FragmentAdapter;
import com.example.myapplication.adapter.ZhiHuAdapter;
import com.example.myapplication.base.BaseMvpInitPreFragment;
import com.example.myapplication.bean.DailyListBean;
import com.example.myapplication.mvp.zhihu.DailyPresenter;
import com.example.myapplication.mvp.zhihu.DailyView;
import com.example.myapplication.utiles.Constants;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class ZhiHuMainFragment extends Fragment{

    private View view;
    private TabLayout tab_zhihu;
    private ViewPager vp_zhihu;
    private ZhiHuFragment zhiHuFragment;

    public ZhiHuMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getContext(),R.layout.fragment_zhu_hu_main,null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tab_zhihu = (TabLayout) view.findViewById(R.id.tab_zhihu);
        vp_zhihu = (ViewPager) view.findViewById(R.id.vp_zhihu);

        //创建子Fragment对象，添加到集合
        zhiHuFragment = new ZhiHuFragment();
        ZhihuThemeFragment zhihuThemeFragment = new ZhihuThemeFragment();
        ZhihuSectionFragment zhihuSectionFragment = new ZhihuSectionFragment();
        ZhihuHotFragment zhihuHotFragment = new ZhihuHotFragment();

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(zhiHuFragment);
        fragments.add(zhihuThemeFragment);
        fragments.add(zhihuSectionFragment);
        fragments.add(zhihuHotFragment);

        //tab标题，写在外面是为了共用
        String[] strings={"日报","主题","专栏","热门"};
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getChildFragmentManager(), fragments, strings);
        vp_zhihu.setAdapter(fragmentAdapter);

        tab_zhihu.setupWithViewPager(vp_zhihu);
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (zhiHuFragment!=null){
            zhiHuFragment.notifyAdapter();
        }
    }
}
