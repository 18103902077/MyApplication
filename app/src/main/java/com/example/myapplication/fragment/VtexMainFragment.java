package com.example.myapplication.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapplication.utiles.Constants;
import com.example.myapplication.R;
import com.example.myapplication.VtexNodeActivity;
import com.example.myapplication.adapter.FragmentAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.张九红  1811a
 */
public class VtexMainFragment extends Fragment implements View.OnClickListener {


    private View view;
    private TabLayout tab_vtex;
    private ViewPager vp_vtex;
    private ImageView manager_vtex_menu;

    public static String[] tabStr = {"技术", "创意", "好玩", "Apple", "酷工作", "交易", "城市", "问与答", "最热", "全部", "R2"};
    public static String[] type = {"tech", "creative", "play", "apple", "jobs", "deals", "city", "qna", "hot", "all", "r2"};


    public VtexMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vtex_main, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tab_vtex = (TabLayout) view.findViewById(R.id.tab_vtex);
        vp_vtex = (ViewPager) view.findViewById(R.id.vp_vtex);
        manager_vtex_menu = (ImageView) view.findViewById(R.id.manager_vtex_menu);//跳转按钮
        manager_vtex_menu.setOnClickListener(this);

        //fragment-vp-tab
        updateTab();

        //tab设置可滑动
        tab_vtex.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    //fragment-vp-tab
    private void updateTab() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        //清空以便更新
        fragments.clear();
        tab_vtex.removeAllTabs();

        int isChechCount=0;     //为了共用FragmentAdapter
        for (int i = 0; i < tabStr.length; i++) {

            isChechCount++;
            VtexComendFragment vtexComendFragment = new VtexComendFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type",type[i]);
            vtexComendFragment.setArguments(bundle);

            fragments.add(vtexComendFragment);

            tab_vtex.addTab(tab_vtex.newTab().setText(tabStr[i]));

        }

        String[] strings=new String[isChechCount];//为了共用FragmentAdapter
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getChildFragmentManager(), fragments, strings);
        vp_vtex.setAdapter(fragmentAdapter);

        tab_vtex.setupWithViewPager(vp_vtex);

        for (int i = 0; i <  tabStr.length; i++) {
                tab_vtex.getTabAt(i).setText(tabStr[i]);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.manager_vtex_menu://跳转
                Intent intent = new Intent(getContext(), VtexNodeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
