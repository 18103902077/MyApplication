package com.example.myapplication.mvp.gank;

import com.example.myapplication.CallBack;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.GankBean;
import com.example.myapplication.bean.GankGirlBean;
import com.example.myapplication.fragment.GankCommendFragment;
import com.example.myapplication.fragment.GankGirlFragment;

public class GankGirlPresenter extends BasePresenter<GankGirlFragment, GankGirlModel> {

    public GankGirlPresenter(GankGirlFragment view) {
        super(view);
    }

    @Override
    protected GankGirlModel initModel() {
        return new GankGirlModel();
    }

    public void getGankGirlList(){
        model.getGankGirl(new CallBack<GankGirlBean>() {
            @Override
            public void getData(GankGirlBean gankGirlBean) {
                view.getGankGirlList(gankGirlBean);
            }

            @Override
            public void getError(String error) {
                view.getError(error);
            }
        });
    }
}
