package com.example.myapplication.mvp.wechat;

import com.example.myapplication.base.Baseview;
import com.example.myapplication.bean.DailyListBean;
import com.example.myapplication.bean.WeChatBean;

public interface WechatView extends Baseview {
    void getDaily(WeChatBean weChatBean);
}
