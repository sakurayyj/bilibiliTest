package com.example.mybilibili.shouye;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.example.mybilibili.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;


public class Fragment_live extends Fragment{

    private String string;
    private Banner mBanner;
    private MyImageLoader mMyImageLoader;
    private ArrayList<Integer> imagePath;
    private ArrayList<String> imageTitle;
    private Activity activity;
    private SwipeRefreshLayout swipeRefresh;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    public Fragment_live(String string, Activity activity, FragmentManager fragmentManager) {
        this.string = string;
        this.activity = activity;
        this.fragmentManager = fragmentManager;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.view_live, container, false);
        //TextView txt = inflate.findViewById(R.id.txt1);
        //txt.setText(string);
//        swipeRefresh = (SwipeRefreshLayout)inflate.findViewById(R.id.swip_refresh);
//        swipeRefresh.setColorSchemeColors(R.color.black);
//        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                refresh(inflate);
//            }
//        });
        initData();
        initView(inflate);
        return inflate;
    }

    private void refresh(View inflate) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.view_live, Fragment_live.this);
                        fragmentTransaction.commit();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }
    private void initData() {
        imagePath = new ArrayList<>();
        imageTitle = new ArrayList<>();
        imagePath.add(R.drawable.other);
        imagePath.add(R.drawable.other);
        imagePath.add(R.drawable.other);
        imageTitle.add("??????????????????");
        imageTitle.add("??????????????????");
        imageTitle.add("??????????????????");
    }

    private void initView(View inflate) {
        mMyImageLoader = new MyImageLoader();
        mBanner = inflate.findViewById(R.id.mBanner);
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
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
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

