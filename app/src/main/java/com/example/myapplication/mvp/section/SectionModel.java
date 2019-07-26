package com.example.myapplication.mvp.section;


import android.util.Log;

import com.example.myapplication.APIService;
import com.example.myapplication.CallBack;
import com.example.myapplication.base.BaseModel;
import com.example.myapplication.bean.SectionListBean;
import com.example.myapplication.bean.WeChatBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SectionModel extends BaseModel {
    private static final String TAG = "tag";
   public void getSectionData(final CallBack callBack){
        new Retrofit.Builder()
                .baseUrl(APIService.sectionlUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIService.class)
                .getSection()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SectionListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SectionListBean sectionListBean) {
                        callBack.getData(sectionListBean);
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
