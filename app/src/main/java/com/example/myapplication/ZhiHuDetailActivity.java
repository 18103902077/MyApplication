package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.bean.LoveBean;
import com.example.myapplication.bean.ZhiHudetailBean;
import com.example.myapplication.utiles.DaoUtitles;
import com.example.myapplication.utiles.HtmlUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//张九红 1811a
public class ZhiHuDetailActivity extends AppCompatActivity {

    private ImageView detail_bar_image;
    private TextView detail_bar_copyright;
    private Toolbar view_toolbar;
    private CollapsingToolbarLayout clp_toolbar;
    private AppBarLayout app_bar;
    private WebView view_main;
    private NestedScrollView nsv_scroller;
    /**
     * 点赞
     */
    private TextView tv_detail_bottom_like;
    /**
     * 评论
     */
    private TextView tv_detail_bottom_comment;
    /**
     * 分享
     */
    private TextView tv_detail_bottom_share;
    private FrameLayout ll_detail_bottom;
    private FloatingActionButton fab_like;
    private static final String TAG = "tag";
    private ZhiHudetailBean loveDetaiBean;
    private int id;
    boolean ischeck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhi_hu_detail);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);

        initView();
        getDetail(id);
    }

    private void getDetail(int myid) {
        new Retrofit.Builder()
                .baseUrl(APIService.zhiHuDetailUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(APIService.class)
                .getDetail(myid)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhiHudetailBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZhiHudetailBean zhiHudetailBean) {
                        loveDetaiBean=zhiHudetailBean;
                        Glide.with(ZhiHuDetailActivity.this).load(zhiHudetailBean.getImage()).into(detail_bar_image);
                        clp_toolbar.setTitle(zhiHudetailBean.getTitle());
                        detail_bar_copyright.setText(zhiHudetailBean.getImage_source());



                        String htmlData = HtmlUtil.createHtmlData(zhiHudetailBean.getBody(), zhiHudetailBean.getCss(), zhiHudetailBean.getJs());
                        view_main.loadData(htmlData,HtmlUtil.MIME_TYPE,HtmlUtil.ENCODING);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ====detail"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void initView() {
        detail_bar_image = (ImageView) findViewById(R.id.detail_bar_image);
        detail_bar_copyright = (TextView) findViewById(R.id.detail_bar_copyright);
        view_toolbar = (Toolbar) findViewById(R.id.view_toolbar);
        clp_toolbar = (CollapsingToolbarLayout) findViewById(R.id.clp_toolbar);
        app_bar = (AppBarLayout) findViewById(R.id.app_bar);
        view_main = (WebView) findViewById(R.id.view_main);
        nsv_scroller = (NestedScrollView) findViewById(R.id.nsv_scroller);
        tv_detail_bottom_like = (TextView) findViewById(R.id.tv_detail_bottom_like);
        tv_detail_bottom_comment = (TextView) findViewById(R.id.tv_detail_bottom_comment);
        tv_detail_bottom_share = (TextView) findViewById(R.id.tv_detail_bottom_share);
        ll_detail_bottom = (FrameLayout) findViewById(R.id.ll_detail_bottom);
        fab_like = (FloatingActionButton) findViewById(R.id.fab_like);


        LoveBean loveBean = new LoveBean();
        loveBean.setMyId(String.valueOf(id));
        LoveBean loveBean1 = DaoUtitles.queryItem(loveBean);
        if (loveBean1!=null){
            fab_like.setSelected(true);
        }else {
            fab_like.setSelected(false);
        }

        fab_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoveBean loveBean = new LoveBean();
                loveBean.setTitle(loveDetaiBean.getTitle());
                loveBean.setImage(loveDetaiBean.getImages().get(0));
                loveBean.setMyId(String.valueOf(id));
                loveBean.setType(1);
                if (ischeck){
                    DaoUtitles.delete(loveBean);
                    ischeck=false;
                    fab_like.setSelected(false);
                }else {
                    DaoUtitles.insert(loveBean);
                    ischeck=true;
                    fab_like.setSelected(true);
                }

            }
        });


    }
}
