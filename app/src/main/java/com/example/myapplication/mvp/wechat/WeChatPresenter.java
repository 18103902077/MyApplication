package com.example.myapplication.mvp.wechat;

import com.example.myapplication.CallBack;
import com.example.myapplication.base.BaseModel;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.base.Baseview;
import com.example.myapplication.bean.WeChatBean;
import com.example.myapplication.fragment.WeChatFragment;

public class WeChatPresenter extends BasePresenter<WeChatFragment, WeChatModel> {

    public WeChatPresenter(WeChatFragment view) {
        super(view);
    }

    @Override
    protected WeChatModel initModel() {
        return new WeChatModel();
    }

    public void getWeChatList(){
        model.getWeChatData(new CallBack<WeChatBean>() {
            @Override
            public void getData(WeChatBean weChatBean) {
                view.getDaily(weChatBean);
            }

            @Override
            public void getError(String error) {
                view.getError(error);
            }
        });
    }
}
