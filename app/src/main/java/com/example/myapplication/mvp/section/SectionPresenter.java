package com.example.myapplication.mvp.section;

import com.example.myapplication.CallBack;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.bean.SectionListBean;
import com.example.myapplication.bean.WeChatBean;
import com.example.myapplication.fragment.WeChatFragment;
import com.example.myapplication.fragment.ZhihuSectionFragment;
import com.example.myapplication.mvp.wechat.WeChatModel;

public class SectionPresenter extends BasePresenter<ZhihuSectionFragment, SectionModel> {

    public SectionPresenter(ZhihuSectionFragment view) {
        super(view);
    }


    @Override
    protected SectionModel initModel() {
        return new SectionModel();
    }

    public void getSectionList(){
        model.getSectionData(new CallBack<SectionListBean>() {
            @Override
            public void getData(SectionListBean sectionListBean) {
                view.getDaily(sectionListBean);
            }

            @Override
            public void getError(String error) {
                view.getError(error);
            }
        });
    }

}
