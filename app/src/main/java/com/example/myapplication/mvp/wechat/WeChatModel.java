package com.example.myapplication.mvp.wechat;


import android.util.Log;

import com.example.myapplication.APIService;
import com.example.myapplication.CallBack;
import com.example.myapplication.base.BaseModel;
import com.example.myapplication.bean.WeChatBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeChatModel extends BaseModel {
    private static final String TAG = "tag";
   public void getWeChatData(final CallBack callBack){
        new Retrofit.Builder()
                .baseUrl(APIService.weChatilUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIService.class)
                .getWeChat()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeChatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WeChatBean weChatBean) {
                        callBack.getData(weChatBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: =======wechat");
                        callBack.getError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
