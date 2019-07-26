package com.example.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.bean.GankBean;

import java.util.ArrayList;
import java.util.List;

public class GankCommendAdapter extends RecyclerView.Adapter<GankCommendAdapter.ViewHolder> {
    Context context;
    List<GankBean.ResultsBean> results =new ArrayList<>();

    public GankCommendAdapter(Context context) {
        this.context = context;
    }

    public void getGankList(List<GankBean.ResultsBean> results){
        this.results.addAll(results);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.gank_commend_item,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        GankBean.ResultsBean resultsBean = results.get(i);
        viewHolder.title.setText(resultsBean.getDesc());
        viewHolder.auther.setText(resultsBean.getWho());
        viewHolder.time.setText(resultsBean.getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView auther;
        TextView time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tv_tech_title);
            auther=itemView.findViewById(R.id.tv_tech_author);
            time=itemView.findViewById(R.id.tv_tech_time);
        }
    }
}
