package com.example.myapplication.mvp.gank;

import com.example.myapplication.APIService;
import com.example.myapplication.CallBack;
import com.example.myapplication.base.BaseModel;
import com.example.myapplication.bean.GankBean;
import com.example.myapplication.bean.GankGirlBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GankGirlModel extends BaseModel {
    private static final String TAG = "tag";

    public void getGankGirl( final CallBack callBack){
        new Retrofit.Builder()
                .baseUrl(APIService.gankGirlUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(APIService.class)
                .getGankGirl()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankGirlBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GankGirlBean gankGirlBean) {
                        callBack.getData(gankGirlBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.getError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
