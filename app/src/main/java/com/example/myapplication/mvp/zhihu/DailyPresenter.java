package com.example.myapplication.mvp.zhihu;

import com.example.myapplication.CallBack;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.DailyListBean;
import com.example.myapplication.bean.ZhiHuBeforeDailyBean;

public class DailyPresenter extends BasePresenter<DailyView,DailyModel> {

    public DailyPresenter(DailyView view) {
        super(view);
    }

    @Override
    protected DailyModel initModel() {
        return new DailyModel();
    }

    public void getStatus(){
        model.getDailyData(new CallBack<DailyListBean>() {//手动加<DailyListBean>
            @Override
            public void getData(DailyListBean dailyListBean) {
                view.getDaily(dailyListBean);
            }

            @Override
            public void getError(String error) {
                view.getError(error);
            }
        });
    }

    public void getBeforeStatus(String date){
        model.getBeforeDailyData(date,new CallBack<ZhiHuBeforeDailyBean>() {//手动加<DailyListBean>
            @Override
            public void getData(ZhiHuBeforeDailyBean zhiHuBeforeDailyBean) {
                view.getBeforeDaily(zhiHuBeforeDailyBean);
            }

            @Override
            public void getError(String error) {
                view.getError(error);
            }
        });
    }
}
