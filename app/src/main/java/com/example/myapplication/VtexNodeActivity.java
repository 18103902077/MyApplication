package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.adapter.VtexNodeAdapter;
import com.example.myapplication.utiles.XmlUtils;

public class VtexNodeActivity extends AppCompatActivity {

    private Toolbar tool_bar;
    private RecyclerView recycler_node;
    private TextView old_text;
    private VtexNodeAdapter vtexNodeAdapter;
    private ArrayMap<String, ArrayMap<String, String>> stringArrayMapArrayMap;
    private int TitleHeight;
    private int mCurrentPosition=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vtex_node);
        initView();
    }

    private static final String TAG = "tag";
    private void initView() {

        try {
            stringArrayMapArrayMap = XmlUtils.parseNodes(this.getResources().getXml(R.xml.nodes));
        } catch (Exception e) {
            e.printStackTrace();
        }

        tool_bar = (Toolbar) findViewById(R.id.tool_bar);
        recycler_node = (RecyclerView) findViewById(R.id.recycler_node);
        old_text = (TextView) findViewById(R.id.old_text);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycler_node.setLayoutManager(linearLayoutManager);
        vtexNodeAdapter = new VtexNodeAdapter(this,stringArrayMapArrayMap);
        recycler_node.setAdapter(vtexNodeAdapter);


        recycler_node.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                TitleHeight = old_text.getHeight(); // 获取固定头部局
                Log.d(TAG, "onScrollStateChanged: "+TitleHeight);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                View view = linearLayoutManager.findViewByPosition(mCurrentPosition + 1);// 因为第一个已经显示，因此获取下一个头部
                if (view != null) {
                    if (view.getTop() <= TitleHeight) {// 当item 头部向上滚动，给固定title 也设置向上滚动
                        old_text.setY(-(TitleHeight - view.getTop()));
                        Log.d(TAG, "onScrolled: "+(TitleHeight - view.getTop()));
                    } else {
                        Log.d(TAG, "onScrolled: setY(0);");
                        old_text.setY(0);
                    }
                }
                if (mCurrentPosition != linearLayoutManager.findFirstVisibleItemPosition()) { // 改变头布局的内容及设置 Y 轴位置
                    mCurrentPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    old_text.setY(0);
                    if (stringArrayMapArrayMap != null) {
                        old_text.setText(stringArrayMapArrayMap.keyAt(mCurrentPosition));

                        Log.d(TAG, "onScrolled:map.keyAt(mCurrentPosition)"+stringArrayMapArrayMap.keyAt(mCurrentPosition));
                    }
                }
            }
        });
        old_text.setText(stringArrayMapArrayMap.keyAt(0));  // 设置默认 头部内容


    }
}
