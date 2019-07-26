package com.example.myapplication.mvp.gank;

import com.example.myapplication.CallBack;
import com.example.myapplication.base.BaseModel;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.Baseview;
import com.example.myapplication.bean.GankBean;
import com.example.myapplication.fragment.GankCommendFragment;

public class GankPresenter extends BasePresenter<GankCommendFragment, GankCommendModel> {

    public GankPresenter(GankCommendFragment view) {
        super(view);
    }

    @Override
    protected GankCommendModel initModel() {
        return new GankCommendModel();
    }

    public void getGankList(String path){
        model.getGank(path, new CallBack<GankBean>() {
            @Override
            public void getData(GankBean GankBean) {
                view.getGankConmmend(GankBean);
            }

            @Override
            public void getError(String error) {
                view.getError(error);
            }
        });
    }
}
