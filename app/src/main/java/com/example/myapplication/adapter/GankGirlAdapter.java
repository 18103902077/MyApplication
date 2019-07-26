package com.example.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.GankBean;
import com.example.myapplication.bean.GankGirlBean;

import java.util.ArrayList;
import java.util.List;

public class GankGirlAdapter extends RecyclerView.Adapter<GankGirlAdapter.ViewHolder> {
    Context context;
    List<GankGirlBean.ResultsBean> girlBeanResults =new ArrayList<>();


    public GankGirlAdapter(Context context) {
        this.context = context;
    }

    public void getGankList(List<GankGirlBean.ResultsBean> girlBeanResults){
        this.girlBeanResults.addAll(girlBeanResults);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context,R.layout.gank_girl,null);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (i==0){
            viewHolder.imgGirl.setMaxHeight(500);
        }
        Glide.with(context).load(girlBeanResults.get(i).getUrl()).into(viewHolder.imgGirl);
    }



    @Override
    public int getItemCount() {
        return girlBeanResults.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgGirl;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgGirl=itemView.findViewById(R.id.img_gan_girl);
        }
    }
}
