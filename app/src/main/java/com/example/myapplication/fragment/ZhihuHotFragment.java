package com.example.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.CallBack;
import com.example.myapplication.R;
import com.example.myapplication.adapter.GankCommendAdapter;
import com.example.myapplication.adapter.ZhiHuAdapter;
import com.example.myapplication.adapter.ZhiHuHotAdapter;
import com.example.myapplication.bean.DailyListBean;
import com.example.myapplication.bean.HotBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuHotFragment extends Fragment {


    private View view;
    private RecyclerView recycler_hot;
    private ZhiHuHotAdapter zhiHuHotAdapter;

    public ZhihuHotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zhihu_hot, container, false);
        initView(view);
        initHot();
        return view;
    }

    private static final String TAG = "tag";
    private void initHot() {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request build = new Request.Builder()
                    .url("http://news-at.zhihu.com/api/4/news/hot")
                    .build();
            okHttpClient.newCall(build).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.d(TAG, "onFailure: ======="+e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String string = response.body().string();
                    if (string==null){//ok解析网络不好会空指针
                        return;
                    }
                    HotBean hotBean = new Gson().fromJson(string, HotBean.class);
                    final List<HotBean.RecentBean> recent = hotBean.getRecent();

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            zhiHuHotAdapter.getHot(recent);
                        }
                    });
                }
            });


    }

    private void initView(View view) {
        recycler_hot = (RecyclerView) view.findViewById(R.id.recycler);
        recycler_hot.setLayoutManager(new LinearLayoutManager(getContext()));
        zhiHuHotAdapter = new ZhiHuHotAdapter(getContext());
        recycler_hot.setAdapter(zhiHuHotAdapter);

    }
}
