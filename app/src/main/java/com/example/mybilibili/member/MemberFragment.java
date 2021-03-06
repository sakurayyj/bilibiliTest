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
        //recyclerView.setNestedScrollingEnabled(false);//????????????
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
        //??????????????????????????????????????????????????????????????????
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //?????????????????????
        mBanner.setImageLoader(mMyImageLoader);
        //???????????????????????????,????????????????????????,????????????????????????
        mBanner.setBannerAnimation(Transformer.Default);
        //?????????????????????
        mBanner.setBannerTitles(imageTitle);
        //????????????????????????
        mBanner.setDelayTime(2000);
        //???????????????????????????????????????true
        mBanner.isAutoPlay(true);
        //???????????????????????????????????????????????????
        mBanner.setIndicatorGravity(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //????????????????????????
        mBanner.setImages(imagePath)
                //??????????????????
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        Toast.makeText(activity, "????????????" + (position + 1) + "????????????", Toast.LENGTH_SHORT).show();
                    }
                })
                //??????????????????????????????????????????
                .start();

    }

    /**
     * ???????????????
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
