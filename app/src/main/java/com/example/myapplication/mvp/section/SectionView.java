package com.example.myapplication.mvp.section;

import com.example.myapplication.base.Baseview;
import com.example.myapplication.bean.SectionListBean;
import com.example.myapplication.bean.WeChatBean;

public interface SectionView extends Baseview {
    void getDaily(SectionListBean sectionListBean);
}
