package com.example.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.LoveAdapter;
import com.example.myapplication.bean.LoveBean;
import com.example.myapplication.utiles.DaoUtitles;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoveFragment extends Fragment {


    private View view;
    private RecyclerView recycler_love;
    private LoveAdapter loveAdapter;

    public LoveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_love, container, false);
        initView(view);
        initLove();
        return view;
    }

    private void initLove() {
        List<LoveBean> loveBeans = DaoUtitles.queryAll();
        loveAdapter.getLove(loveBeans);
    }

    private void initView(View view) {
        recycler_love = (RecyclerView) view.findViewById(R.id.recycler_love);
        recycler_love.setLayoutManager(new LinearLayoutManager(getContext()));
        loveAdapter = new LoveAdapter(getContext());
        recycler_love.setAdapter(loveAdapter);
    }

  /*  @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&loveAdapter!=null){
            initLove();
        }
    }*/

  //Fragment显示隐藏监听
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            initLove();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        loveAdapter.query();
    }
}
