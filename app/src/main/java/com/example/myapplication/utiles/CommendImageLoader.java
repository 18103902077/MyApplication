package com.example.myapplication.utiles;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myapplication.base.BaseApplication;

public class CommendImageLoader {
    public  static void getImage(String url, ImageView img){
        if (!Constants.isNoImage){
            Glide.with(BaseApplication.getInstance()).load(url).into(img);
        }else {
            img.setImageResource(0);
        }

    }
}
