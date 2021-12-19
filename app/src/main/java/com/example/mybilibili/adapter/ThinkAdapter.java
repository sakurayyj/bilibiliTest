package com.example.mybilibili.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mybilibili.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ThinkAdapter extends RecyclerView.Adapter<ThinkAdapter.ViewHolder> {

    List<Think> list ;

    public ThinkAdapter(List<Think> list){
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.think_wyw,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ThinkAdapter.ViewHolder holder, int position) {
        Think think = list.get(position);
        holder.circleImageView.setImageResource(think.getCiv());
        holder.textView.setText(think.getTxt());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView circleImageView ;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.think_civ);
            textView = itemView.findViewById(R.id.think_txt);
        }
    }
}
