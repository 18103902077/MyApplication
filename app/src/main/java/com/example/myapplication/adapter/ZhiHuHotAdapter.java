package com.example.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.DailyListBean;
import com.example.myapplication.bean.HotBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class ZhiHuHotAdapter extends RecyclerView.Adapter<ZhiHuHotAdapter.ViewHolder> {

    Context context;
    List<HotBean.RecentBean> recentBeans =new ArrayList<>();


    public ZhiHuHotAdapter(Context context) {
        this.context = context;
    }

    public void getHot(List<HotBean.RecentBean> recentBeans) {//需要先加头布局，否则越界
        this.recentBeans.addAll(recentBeans);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_daily,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        HotBean.RecentBean recentBean = recentBeans.get(i);
        viewHolder.title.setText(recentBean.getTitle());
        Glide.with(context).load(recentBean.getThumbnail()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return recentBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_con);
            title=itemView.findViewById(R.id.title_con);
        }
    }
}
