package com.example.mybilibili.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mybilibili.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.ViewHolder> {

    List<Recommend> list ;
    Context context;

    public RecommendAdapter(List<Recommend> list){
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recommend,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Recommend recommend = list.get(position);
        holder.imageView1.setImageResource(recommend.getId1());
        Log.d("id",recommend.getId1()+"");
        holder.textView1.setText(recommend.getTxt1());
        Log.d("id",recommend.getTxt1()+"");
        holder.imageView2.setImageResource(recommend.getId2());
        holder.textView2.setText(recommend.getTxt2());
        holder.imageView3.setImageResource(recommend.getId3());
        holder.textView3.setText(recommend.getTxt3());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView1;
        TextView textView1;
        ImageView imageView2;
        TextView textView2;
        ImageView imageView3;
        TextView textView3;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView1 = itemView.findViewById(R.id.little_tv1);
            textView1 = itemView.findViewById(R.id.textview1);
            imageView2 = itemView.findViewById(R.id.little_tv2);
            textView2 = itemView.findViewById(R.id.textview2);
            imageView3 = itemView.findViewById(R.id.little_tv3);
            textView3 = itemView.findViewById(R.id.textview3);
        }
    }
}