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
import com.example.myapplication.bean.HotBean;
import com.example.myapplication.bean.SectionListBean;

import java.util.ArrayList;
import java.util.List;

public class ZhiHuSectionAdapter extends RecyclerView.Adapter<ZhiHuSectionAdapter.ViewHolder> {

    Context context;
    List<SectionListBean.DataBean> data =new ArrayList<>();


    public ZhiHuSectionAdapter(Context context) {
        this.context = context;
    }

    public void getSection(List<SectionListBean.DataBean> data) {//需要先加头布局，否则越界
        this.data.addAll(data);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_section,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        SectionListBean.DataBean dataBean = data.get(i);
        viewHolder.name.setText(dataBean.getName());
        viewHolder.title.setText(dataBean.getDescription());
        Glide.with(context).load(dataBean.getThumbnail()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.section_bg);
            title=itemView.findViewById(R.id.section_des);
            name=itemView.findViewById(R.id.section_kind);
        }
    }
}
