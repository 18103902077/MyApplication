package com.example.myapplication.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * 张九红  1811a
 */
public class GankMainFragment extends Fragment {
   // Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App|all
    private final String ANDROID="Android";
    private final String IOS="iOS";
    private final String WEB="前端";
    private final String GIRL="福利";

    private View view;
    private TabLayout tab_gank;
    private ViewPager vp_gank;

    public GankMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.fragment_gank_main, container, false);
        View view = View.inflate(getContext(),R.layout.fragment_gank_main,null);
        initView(view);
        return view;
    }
    //多个Fragment共用，布局效果一样
    private void initView(View view) {
        tab_gank = (TabLayout) view.findViewById(R.id.tab_gank);
        vp_gank = (ViewPager) view.findViewById(R.id.vp_gank);

        //多个Fragment共用，布局效果一样
        //用Bundle将url中不同的部分传给共用Fragment
        GankCommendFragment android = new GankCommendFragment();
        Bundle bundle = new Bundle();
        bundle.putString("path",ANDROID);
        android.setArguments(bundle);

        GankCommendFragment ios = new GankCommendFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("path",IOS);
        ios.setArguments(bundle1);

        GankCommendFragment web = new GankCommendFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("path",WEB);
        web.setArguments(bundle2);

        GankGirlFragment girl = new GankGirlFragment();

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(android);
        fragments.add(ios);
        fragments.add(web);
        fragments.add(girl);

        String[] strings={"Andriod","IOS","前端","福利"};
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getChildFragmentManager(), fragments, strings);
        vp_gank.setAdapter(fragmentAdapter);

        tab_gank.setupWithViewPager(vp_gank);


    }
}
