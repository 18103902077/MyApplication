package com.example.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.utiles.FlowLayout;
import com.example.myapplication.R;
import com.example.myapplication.utiles.SystemUtil;

public class VtexNodeAdapter extends RecyclerView.Adapter<VtexNodeAdapter.ViewHolder> {
    Context context;
    private LayoutInflater inflater;
    private ArrayMap<String, ArrayMap<String, String>> mMap;

    public VtexNodeAdapter(Context context, ArrayMap<String, ArrayMap<String, String>> mMap) {
        this.context = context;
        this.mMap = mMap;
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=View.inflate(context,R.layout.item_node,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvTitle.setText(mMap.keyAt(position));
        holder.flowLayout.removeAllViews();
        ArrayMap<String, String> mNodeBlock = mMap.valueAt(position);
        for (ArrayMap.Entry<String, String> node : mNodeBlock.entrySet()) {
            TextView tvNode = new TextView(context);
            tvNode.setText(node.getValue());
            tvNode.setTextColor(ContextCompat.getColor(context, R.color.colorText));
            tvNode.setPadding(SystemUtil.dp2px(6f), SystemUtil.dp2px(6f), SystemUtil.dp2px(6f), SystemUtil.dp2px(6f));
//            tvNode.setOnClickListener(new OnNodeClickListener(node.getKey()));
            holder.flowLayout.addView(tvNode);
        }
    }

    @Override
    public int getItemCount() {
        return mMap.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        FlowLayout flowLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.item_node_title);
            flowLayout=itemView.findViewById(R.id.flow_node_content);
        }
    }
}
