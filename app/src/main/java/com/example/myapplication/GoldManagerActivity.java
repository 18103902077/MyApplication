package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.myapplication.adapter.GoldManagerAdapter;
import com.example.myapplication.utiles.Constants;

import java.util.Collections;

public class GoldManagerActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recycler_gold_manager;
    private GoldManagerAdapter goldManagerAdapter;
    private DefaultItemTouchHelpCallback mCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gold_manager);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recycler_gold_manager = (RecyclerView) findViewById(R.id.recycler_gold_manager);

        toolbar.setTitle("Tab");
        setSupportActionBar(toolbar);

        //布局管理器-适配器
        recycler_gold_manager.setLayoutManager(new LinearLayoutManager(this));
        goldManagerAdapter = new GoldManagerAdapter(this);
        recycler_gold_manager.setAdapter(goldManagerAdapter);


        //长按条目，交换位置动效
        mCallback = new DefaultItemTouchHelpCallback(new DefaultItemTouchHelpCallback.OnItemTouchCallbackListener() {
            @Override
            public void onSwiped(int adapterPosition) {
            }


            @Override
            public boolean onMove(int srcPosition, int targetPosition) {
                // 判断 集合不为null
                if (Constants.goldStatuses != null) {
                    //交换 集合里  源位置  和 目标位置
                    Collections.swap(Constants.goldStatuses, srcPosition, targetPosition);
                    goldManagerAdapter.notifyItemMoved(srcPosition, targetPosition);
                    return true;
                }
                return false;
            }
        });
        mCallback.setDragEnable(true);
        mCallback.setSwipeEnable(false);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(mCallback);
        itemTouchHelper.attachToRecyclerView(recycler_gold_manager);


    }

    //当界面返回（销毁）是发送广播，以便tab-fragment的数据随着更新
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent();
        intent.setAction("update.gold");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
