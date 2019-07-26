package com.example.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.myapplication.utiles.Constants;
import com.example.myapplication.R;
import com.example.myapplication.bean.GoldStatus;

public class GoldManagerAdapter extends RecyclerView.Adapter<GoldManagerAdapter.ViewHolder> {
    Context context;

    public GoldManagerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.goldmanager, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        GoldStatus goldStatus = Constants.goldStatuses.get(i);
        viewHolder.type.setText(goldStatus.getTitle());
        viewHolder.switchCompat.setChecked(goldStatus.isSelected());//设置按钮的初始状态，从集合中获取状态

        //监听选择按钮，当改变是将boolean isChecked设置给集合（Constants.goldStatuses）中对应字段
        viewHolder.switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Constants.goldStatuses.get(viewHolder.getAdapterPosition()).setSelected(isChecked);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Constants.goldStatuses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView type;
        SwitchCompat switchCompat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            type=itemView.findViewById(R.id.tv_gold_manager_type);
            switchCompat=itemView.findViewById(R.id.sc_gold_manager_switch);
        }
    }
}
