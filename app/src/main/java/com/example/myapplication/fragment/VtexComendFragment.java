package com.example.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.TopicAdapter;
import com.example.myapplication.bean.TopicListBean;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class VtexComendFragment extends Fragment {


    private View view;
    private RecyclerView viewMain;
    private String type;
    private TopicAdapter topicAdapter;
    private ArrayList<TopicListBean> topicListBeanList;

    public VtexComendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vtex_comend, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        type = getArguments().getString("type");

        viewMain=view.findViewById(R.id.view_main);
        viewMain.setLayoutManager(new LinearLayoutManager(getActivity()));

        topicAdapter = new TopicAdapter(getActivity());

        viewMain.setAdapter(topicAdapter);


        initData(type);
    }

    public void initData(final String type){


        new Thread(){
            @Override
            public void run() {
                super.run();


                try {
                    Document doc = Jsoup.connect("https://www.v2ex.com/?tab=" + type).timeout(10000).get();

                    Elements itemElements = doc.select("div.cell.item");

                    topicListBeanList = new ArrayList<>();
                    for (int x=0;x<itemElements.size();x++){


                        Elements titleEle = itemElements.get(x).select("div.cell.item table tr td span.item_title > a");
                        Elements imgEle = itemElements.get(x).select("div.cell.item table tr td img.avatar");
                        Elements commentEle = itemElements.get(x).select("div.cell.item table tr a.count_livid");

                        TopicListBean topicListBean = new TopicListBean();

                        if (titleEle.size()>0){
                            topicListBean.setTitle(titleEle.get(0).text());
                        }
                        if (imgEle.size()>0){

                            topicListBean.setImgUrl("http:"+imgEle.get(0).attr("src"));
                        }

                        if (commentEle.size()>0){
                            String topicId = commentEle.get(0).attr("href");

                            String text = commentEle.get(0).text();

                            int i = topicId.indexOf("#");

                            topicId = topicId.substring(3,i);


                            topicListBean.setCommentNum(Integer.valueOf(topicId));
                        }

                        topicListBeanList.add(topicListBean);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }


                if (getActivity()==null){
                    return;
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        topicAdapter.initData(topicListBeanList);
                    }
                });

            }
        }.start();


    }
}
