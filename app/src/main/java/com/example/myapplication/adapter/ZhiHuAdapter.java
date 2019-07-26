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

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.ZhiHuDetailActivity;
import com.example.myapplication.bean.DailyListBean;
import com.example.myapplication.bean.ZhiHuBeforeDailyBean;
import com.example.myapplication.utiles.CommendImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class ZhiHuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int BANNERS=0;
    private final int DATE=1;
    private final int DAILY=2;

    Context context;
    List<DailyListBean.StoriesBean> stories =new ArrayList<>();
    List<DailyListBean.TopStoriesBean> topStories =new ArrayList<>();
    List<ZhiHuBeforeDailyBean.StoriesBean> zhiHuBeforeStories =new ArrayList<>();
    boolean isBefore;
    String dates="";

    public ZhiHuAdapter(Context context) {
        this.context = context;
    }

    public void getStores(DailyListBean dailyListBean) {//需要先加头布局，否则越界
        this.topStories.addAll(dailyListBean.getTop_stories());
        this.stories.addAll(dailyListBean.getStories());
        notifyDataSetChanged();
    }
    public void getBeforeStores(ZhiHuBeforeDailyBean zhiHuBeforeDailyBean) {//需要先加头布局，否则越界
        this.zhiHuBeforeStories.clear();
        this.zhiHuBeforeStories.addAll(zhiHuBeforeDailyBean.getStories());
        notifyDataSetChanged();
    }

    public void refreshBefore(boolean isBefore,String dates){
        this.isBefore=isBefore;
        this.dates=dates;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i){
            case BANNERS:
                return new BannerViewHolder(View.inflate(context,R.layout.mybanner,null));
            case DATE:
                return new DateViewHolder(View.inflate(context,R.layout.date,null));
            case DAILY:
                return new DailyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_daily,viewGroup,false));
                //return new DailyViewHolder(View.inflate(context,R.layout.conmentlist,null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {

        if (!isBefore){
            if (viewHolder instanceof BannerViewHolder){
                ((BannerViewHolder) viewHolder).ban.setImages(topStories).setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        DailyListBean.TopStoriesBean paths= (DailyListBean.TopStoriesBean) path;
                        Glide.with(context).load(paths.getImage()).into(imageView);
                    }
                }).start();
            } else if (viewHolder instanceof DateViewHolder) {
                ((DateViewHolder) viewHolder).date.setText("今日热闻");
            }else {

                if (topStories.size()>0){//布局先后顺序固定
                    i=i-1;
                }
                if (dates!=null&&i>=1){
                    i=i-1;
                }
                if (stories.size()<=0){
                    return;
                }
                DailyViewHolder viewHolder1= (DailyViewHolder) viewHolder;
                final DailyListBean.StoriesBean storiesBean = stories.get(i);
                viewHolder1.title.setText(storiesBean.getTitle());

                CommendImageLoader.getImage(storiesBean.getImages().get(0),viewHolder1.img);
                //Glide.with(context).load(storiesBean.getImages().get(0)).into(viewHolder1.img);

                viewHolder1.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int id = storiesBean.getId();
                        Intent intent = new Intent(context, ZhiHuDetailActivity.class);
                        intent.putExtra("id",id);
                        context.startActivity(intent);
                    }
                });
            }
        }else {
            if (viewHolder instanceof DateViewHolder) {
                ((DateViewHolder) viewHolder).date.setText(dates);
            }else {
                if (dates!=null&&i>=1){
                    i=i-1;
                }
                if (zhiHuBeforeStories.size()<=0){
                    return;
                }
                DailyViewHolder viewHolder1= (DailyViewHolder) viewHolder;
                final ZhiHuBeforeDailyBean.StoriesBean BeforeStoriesBean = zhiHuBeforeStories.get(i);
                viewHolder1.title.setText(BeforeStoriesBean.getTitle());

                Glide.with(context).load(BeforeStoriesBean.getImages().get(0)).into(viewHolder1.img);

                viewHolder1.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int id = BeforeStoriesBean.getId();
                        Intent intent = new Intent(context, ZhiHuDetailActivity.class);
                        intent.putExtra("id",id);
                        context.startActivity(intent);
                    }
                });
            }
        }

    }

    @Override
    public int getItemCount() {
        int size=0;
        if (!isBefore) {
            if (stories.size()>0){
                size=stories.size();
            }
            if (topStories.size()>0){
                size+=1;
            }
            if (dates!=null){
                size+=1;
            }
        }else {
            if (zhiHuBeforeStories.size()>0){
                size=zhiHuBeforeStories.size();
            }
            if (dates!=null){
                size+=1;
            }
        }

        return size;
    }

    @Override
    public int getItemViewType(int position) {
        if (!isBefore){
            if (position==0&&topStories.size()>0){
                return BANNERS;
            }else if (position==1&&dates!=null){
                return DATE;
            }else {
                return DAILY;
            }
        }else {
            if (position==0&&dates!=null){
                return DATE;
            }else {
                return DAILY;
            }
        }
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder{
        Banner ban;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            ban=itemView.findViewById(R.id.ban);
        }
    }
    public class DateViewHolder extends RecyclerView.ViewHolder{
        TextView date;
        public DateViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.date);
        }
    }
    public class DailyViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        public DailyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img_con);
            title=itemView.findViewById(R.id.title_con);
        }
    }

}
