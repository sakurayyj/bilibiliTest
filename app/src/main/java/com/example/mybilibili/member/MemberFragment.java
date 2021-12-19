package com.example.mybilibili.member;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mybilibili.R;
import com.example.mybilibili.adapter.MemberAdapter;
import com.example.mybilibili.adapter.RecommendAdapter;
import com.example.mybilibili.shouye.Fragment_live;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class MemberFragment extends Fragment {

    private Banner mBanner;
    private MemberFragment.MyImageLoader mMyImageLoader;
    private ArrayList<Integer> imagePath;
    private Activity activity;
    private ArrayList<String> imageTitle;
    private List list = new ArrayList();

    public MemberFragment(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_member, container, false);
        init();
        initRecyclerview(inflate);
        initData();
        initView(inflate);
        return inflate;
    }

    private void initRecyclerview(View inflate) {
        RecyclerView recyclerView = inflate.findViewById(R.id.member_main);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        MemberAdapter adapter = new MemberAdapter(list);
        //recyclerView.setNestedScrollingEnabled(false);//禁止滑动
        recyclerView.setAdapter(adapter);
    }

    private void init() {
        for(int i = 0;i < 20; i++){
            list.add("");
        }
    }

    private void initData() {
        imagePath = new ArrayList<>();
        imageTitle = new ArrayList<>();
        imagePath.add(R.drawable.other);
        imagePath.add(R.drawable.other);
        imagePath.add(R.drawable.other);
        imageTitle.add("");
        imageTitle.add("");
        imageTitle.add("");
    }

    private void initView(View inflate) {
        mMyImageLoader = new MemberFragment.MyImageLoader();
        mBanner = inflate.findViewById(R.id.mBanner2);
        //设置样式，里面有很多种样式可以自己都看看效果
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        mBanner.setImageLoader(mMyImageLoader);
        //设置轮播的动画效果,里面有很多种特效,可以都看看效果。
        mBanner.setBannerAnimation(Transformer.Default);
        //轮播图片的文字
        mBanner.setBannerTitles(imageTitle);
        //设置轮播间隔时间
        mBanner.setDelayTime(2000);
        //设置是否为自动轮播，默认是true
        mBanner.isAutoPlay(true);
        //设置指示器的位置，小点点，居中显示
        mBanner.setIndicatorGravity(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载地址
        mBanner.setImages(imagePath)
                //轮播图的监听
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        Toast.makeText(activity, "你点了第" + (position + 1) + "张轮播图", Toast.LENGTH_SHORT).show();
                    }
                })
                //开始调用的方法，启动轮播图。
                .start();

    }

    /**
     * 图片加载类
     */
    private class MyImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext())
                    .load(path)
                    .into(imageView);
        }
    }
}
