package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.ZhiHuDetailActivity;
import com.example.myapplication.bean.HotBean;
import com.example.myapplication.bean.LoveBean;
import com.example.myapplication.utiles.DaoUtitles;

import java.util.ArrayList;
import java.util.List;

public class LoveAdapter extends RecyclerView.Adapter<LoveAdapter.ViewHolder> {

    Context context;
    List<LoveBean> loveBeans =new ArrayList<>();
    int index=0;

    public LoveAdapter(Context context) {
        this.context = context;
    }

    public void getLove(List<LoveBean> loveBeans) {//需要先加头布局，否则越界
        this.loveBeans.clear();
        this.loveBeans.addAll(loveBeans);
        notifyDataSetChanged();
    }

    public void delete(){
        DaoUtitles.delete(loveBeans.get(index));
        loveBeans.remove(index);
        notifyDataSetChanged();
    }
    public void query(){
        this.loveBeans.clear();
        List<LoveBean> loveBeans = DaoUtitles.queryAll();
        this.loveBeans.addAll(loveBeans);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_love,null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        LoveBean loveBean = loveBeans.get(i);
        viewHolder.title.setText(loveBean.getTitle());
        viewHolder.from.setText(getType(loveBean.getType()));
        Glide.with(context).load(loveBean.getImage()).into(viewHolder.img);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoveBean loveBean1 = loveBeans.get(i);
                int type = loveBean1.getType();
                if (type==1){
                    Intent intent = new Intent(context, ZhiHuDetailActivity.class);
                    intent.putExtra("id",Integer.parseInt(loveBean1.getMyId()));
                    context.startActivity(intent);
                }else if (type==2){

                }
            }
        });

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                index=i;
                delete();
                Toast.makeText(context, "删除成功", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    public String getType(int type){
        switch (type){
            case 1:
                return "来自知乎";
            case 2:
                return "来自微信";
        }
        return "";
    }

    @Override
    public int getItemCount() {
        return loveBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        TextView from;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_love);
            title=itemView.findViewById(R.id.title_love);
            from=itemView.findViewById(R.id.from_love);
        }
    }
}
