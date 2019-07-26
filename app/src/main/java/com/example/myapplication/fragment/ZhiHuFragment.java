package com.example.myapplication.fragment;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myapplication.MainActivity;
import com.example.myapplication.utiles.DateUtils;
import com.example.myapplication.R;
import com.example.myapplication.ZhiHuCalendarActivity;
import com.example.myapplication.adapter.ZhiHuAdapter;
import com.example.myapplication.base.BaseMvpInitPreFragment;
import com.example.myapplication.bean.DailyListBean;
import com.example.myapplication.bean.ZhiHuBeforeDailyBean;
import com.example.myapplication.mvp.zhihu.DailyPresenter;
import com.example.myapplication.mvp.zhihu.DailyView;
import com.youth.banner.loader.ImageLoader;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class ZhiHuFragment extends BaseMvpInitPreFragment<DailyPresenter> implements DailyView {


    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;
    @BindView(R.id.float_calender)
    FloatingActionButton floatCalender;
    Unbinder unbinder1;
    private ZhiHuAdapter zhiHuAdapter;


    /*
    banner头部，有title，滑动，翻页
    ban.setBannerTitles(titles)
            .setImages(integers)
                .setBannerStyle(Gravity.LEFT)
                .setImageLoader(new ImageLoader() {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Integer paths = (Integer) path;
            Glide.with(MainActivity.this).load(paths).into(imageView);
        }
    }).start();
    */

    //初始化p层
    @Override
    protected DailyPresenter initPresenter() {
        return new DailyPresenter(this);
    }

    @Override
    protected void initView() {
        initBroadcastReceiver();    //注册广播

        //绑定适配器
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        zhiHuAdapter = new ZhiHuAdapter(getContext());
        recycler.setAdapter(zhiHuAdapter);

        //调用p层方法
        presenter.getStatus();
    }

    //注册广播
    private void initBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter("com.myapplication.date");
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(broadcastReceiver,intentFilter);
    }
    //取消广播
    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(broadcastReceiver);

    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_zhu_hu;
    }

    //初始化界面数据，如果日期是今日，调用该方法
    @Override
    public void getDaily(final DailyListBean dailyListBean) {

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                zhiHuAdapter.getStores(dailyListBean);
            }
        });
    }

    //如果日期是往日，调用该方法
    @Override
    public void getBeforeDaily(final ZhiHuBeforeDailyBean zhiHuBeforeDailyBean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                zhiHuAdapter.getBeforeStores(zhiHuBeforeDailyBean);
            }
        });
    }

    private static final String TAG = "tag";
    @Override
    public void getError(String error) {
        Log.d(TAG, "getError:=======" + error);
    }

    //点击日历跳转到日历页面
    @OnClick(R.id.float_calender)
    public void onClick() {
        startActivity(new Intent(getContext(), ZhiHuCalendarActivity.class));
    }

    //广播接收器
    boolean isBefore;//传入适配，以便判断
    BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String date = intent.getStringExtra("date");

            String yyyymmdd = DateUtils.getYYYYMMDD();//当前日期
            if (date.equals(yyyymmdd)){//判断是当前日期
                isBefore=false;
                zhiHuAdapter.refreshBefore(isBefore,"今日热闻");
                presenter.getStatus();  //调用当前日期的方法
            }else {
                isBefore=true;
                zhiHuAdapter.refreshBefore(isBefore,date);
                presenter.getBeforeStatus(date);//否则调用以前数据的方法
            }
        }
    };

    public void notifyAdapter(){
        if (zhiHuAdapter!=null){
            zhiHuAdapter.notifyDataSetChanged();
        }
    }
}
