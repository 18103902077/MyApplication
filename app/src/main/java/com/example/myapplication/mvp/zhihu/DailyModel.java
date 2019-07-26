package com.example.myapplication.mvp.zhihu;

import android.util.Log;

import com.example.myapplication.CallBack;
import com.example.myapplication.base.BaseModel;
import com.example.myapplication.bean.DailyListBean;
import com.example.myapplication.bean.ZhiHuBeforeDailyBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DailyModel extends BaseModel {
    private static final String TAG = "tag";
    public void getDailyData(final CallBack callBack){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder()
                .url("http://news-at.zhihu.com/api/4/news/latest")
                .build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.getError(e.getMessage());
                Log.d(TAG, "onFailure: ======="+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response==null){
                    return;
                }
                String string = response.body().string();
                DailyListBean dailyListBean = new Gson().fromJson(string, DailyListBean.class);
                callBack.getData(dailyListBean);
            }
        });

    }


    public void getBeforeDailyData(String date,final CallBack callBack){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request build = new Request.Builder()
                .url("http://news-at.zhihu.com/api/4/news/before/"+date)
                .build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.getError(e.getMessage());
                Log.d(TAG, "onFailure: ======="+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response==null){
                    return;
                }
                String string = response.body().string();
                ZhiHuBeforeDailyBean zhiHuBeforeDailyBean = new Gson().fromJson(string, ZhiHuBeforeDailyBean.class);
                callBack.getData(zhiHuBeforeDailyBean);
            }
        });

    }
}
