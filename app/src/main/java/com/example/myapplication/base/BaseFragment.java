package com.example.myapplication.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

//此类为抽取Fragment中，公有的数据
public abstract class BaseFragment extends Fragment {

    private Unbinder bind;

   /* @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view=inflater.inflate(initLayout(),null);
        bind = ButterKnife.bind(this, view);

        initPresent();
        initView();
        return view;
    }

    protected abstract void initView();

    protected abstract void initPresent();//p层方法

    protected abstract int initLayout();//布局

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
