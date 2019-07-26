package com.example.myapplication;

import com.example.myapplication.bean.GankBean;
import com.example.myapplication.bean.GankGirlBean;
import com.example.myapplication.bean.SectionListBean;
import com.example.myapplication.bean.WeChatBean;
import com.example.myapplication.bean.ZhiHuBeforeDailyBean;
import com.example.myapplication.bean.ZhiHudetailBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {
    //"http://gank.io/api/data/iOS/20/1"
    String gankUrl="http://gank.io/api/";
    @GET("data/{path}/{num}/{page}")
    Observable<GankBean> getGankCommend(@Path("path") String path,@Path("num") int num,@Path("page") int page);

    String gankGirlUrl="http://gank.io/api/";
    @GET("data/%E7%A6%8F%E5%88%A9/10/1")
    Observable<GankGirlBean> getGankGirl();


    String zhiHuDetailUrl="http://news-at.zhihu.com/";
    @GET("api/4/news/{myid}")
    Observable<ZhiHudetailBean> getDetail(@Path("myid")int myid);


    String weChatilUrl="http://api.tianapi.com/";
    @GET("wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1")
    Observable<WeChatBean> getWeChat();



    String sectionlUrl="http://news-at.zhihu.com/";
    @GET("api/4/sections")
    Observable<SectionListBean> getSection();

}
