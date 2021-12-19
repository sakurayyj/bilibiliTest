package com.example.mybilibili.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mybilibili.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ThinkAdapter2 extends RecyclerView.Adapter<ThinkAdapter2.ViewHolder>{
    List<Think2> list ;

    public ThinkAdapter2(List<Think2> list){
        this.list = list;
    }

    @Override
    public ThinkAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_think,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Think2 think = list.get(position);
        holder.textView1.setText(think.getTxt1());
        holder.textView2.setText(think.getTxt2());
        holder.textView3.setText(think.getTxt3());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
        public ViewHolder(View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.gengxinzhi);
            textView2 = itemView.findViewById(R.id.fan_title);
            textView3 = itemView.findViewById(R.id.fensi);
        }
    }
}
