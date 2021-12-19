package com.example.mybilibili.dongtai;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mybilibili.R;
import com.example.mybilibili.adapter.Recommend;
import com.example.mybilibili.adapter.RecommendAdapter;
import com.example.mybilibili.adapter.ThinkAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment_synthesize extends Fragment {

    private Activity activity;
    private List<Recommend> list = new ArrayList<>();

    public Fragment_synthesize(Activity activity) {
        // Required empty public constructor
        this.activity = activity;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_synthesize, container, false);
        init(inflate);
        RecyclerView recyclerView = inflate.findViewById(R.id.rec_huati);
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        RecommendAdapter adapter = new RecommendAdapter(list);
        recyclerView.setAdapter(adapter);
        return inflate;
    }

    private void init(View inflate) {
        Recommend recommend1 = new Recommend(R.drawable.lqbz,"萌宠观察局",R.drawable.lqbz,"不正经的知识更新了",R.drawable.lqbz,"书桌改造计划");
        Recommend recommend2 = new Recommend(R.drawable.lqbz,"声优都是怪物",R.drawable.lqbz,"这就是足球",R.drawable.lqbz,"如何找到自己真正想做的事情");
        Recommend recommend3 = new Recommend(R.drawable.lqbz,"B站自习室每日打卡",R.drawable.lqbz,"冬日电影游园会",R.drawable.lqbz,"如何战胜被论文支配的恐惧");
        list.add(recommend1);
        list.add(recommend2);
        list.add(recommend3);
    }
}