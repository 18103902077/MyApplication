package com.example.myapplication.fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapplication.utiles.Constants;
import com.example.myapplication.GoldManagerActivity;
import com.example.myapplication.R;
import com.example.myapplication.adapter.FragmentAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoldMainFragment extends Fragment implements View.OnClickListener {


    private View view;
    private TabLayout tab_gold;
    private ViewPager vp_gold;
    private ImageView manager_gold_menu;

    public GoldMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gold_main, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tab_gold = (TabLayout) view.findViewById(R.id.tab_gold);
        vp_gold = (ViewPager) view.findViewById(R.id.vp_gold);
        manager_gold_menu = (ImageView) view.findViewById(R.id.manager_gold_menu);//跳转按钮
        manager_gold_menu.setOnClickListener(this);

        //注册广播
        IntentFilter intentFilter = new IntentFilter("update.gold");
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(broadcastReceiver,intentFilter);

        //fragment-vp-tab
        updateTab();

        //tab设置可滑动
        tab_gold.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    //fragment-vp-tab
    private void updateTab() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        //清空以便更新
        fragments.clear();
        tab_gold.removeAllTabs();

        int isChechCount=0;     //为了共用FragmentAdapter
        for (int i = 0; i < Constants.goldStatuses.size(); i++) {
            boolean selected = Constants.goldStatuses.get(i).isSelected();
            if (selected){      //如果集合中是true，添加fragment
                isChechCount++;
                GoldComendFragment goldComendFragment = new GoldComendFragment();
                fragments.add(goldComendFragment);
               // tab_gold.addTab(tab_gold.newTab().setText(Constants.goldStatuses.get(i).getTitle()));
            }
        }

        String[] strings=new String[isChechCount];//为了共用FragmentAdapter
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getChildFragmentManager(), fragments, strings);
        vp_gold.setAdapter(fragmentAdapter);

        tab_gold.setupWithViewPager(vp_gold);

        int index=0;
        for (int i = 0; i < Constants.goldStatuses.size(); i++) {
            boolean selected = Constants.goldStatuses.get(i).isSelected();
            if (selected){      //tab的下标从0开始     获取集合中对应的title
                tab_gold.getTabAt(index++).setText(Constants.goldStatuses.get(i).getTitle());
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.manager_gold_menu://跳转
                Intent intent = new Intent(getContext(), GoldManagerActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(broadcastReceiver);
    }

    //广播接收器
    BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateTab();
        }
    };

}
