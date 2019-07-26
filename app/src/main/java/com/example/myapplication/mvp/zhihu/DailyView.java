package com.example.myapplication.mvp.zhihu;

import com.example.myapplication.base.Baseview;
import com.example.myapplication.bean.DailyListBean;
import com.example.myapplication.bean.ZhiHuBeforeDailyBean;

public interface DailyView extends Baseview {
    void getDaily(DailyListBean dailyListBean);

    void getBeforeDaily(ZhiHuBeforeDailyBean zhiHuBeforeDailyBean);
}
