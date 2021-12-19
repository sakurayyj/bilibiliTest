package com.example.mybilibili.shouye;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mybilibili.R;
import com.example.mybilibili.adapter.MyPagerAdapter;
import com.example.mybilibili.adapter.Think;
import com.example.mybilibili.adapter.Think2;
import com.example.mybilibili.adapter.ThinkAdapter;
import com.example.mybilibili.adapter.ThinkAdapter2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link Fragment_cartoon#newInstance} factory method to
// * create an instance of this fragment.
// */
public class Fragment_cartoon extends Fragment {
//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    private List<Think> list = new ArrayList<>();
    private List<Think2> list2 = new ArrayList<>();
    private Activity activity;
    private Banner mBanner;
    private Fragment_cartoon.MyImageLoader mMyImageLoader;
    private ArrayList<Integer> imagePath;
    private ArrayList<String> imageTitle;
    private ViewPager2 viewPager2;
    private MyPagerAdapter myPageAdapter;
    private ArrayList<Fragment> fragmentList;
    private boolean isHomeLastPage = false;
    private boolean isHomeDragPage = false;

    public Fragment_cartoon(Activity activity) {
        // Required empty public constructor
        this.activity = activity;
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment Fragment_cartoon.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static Fragment_cartoon newInstance(String param1, String param2) {
//        Fragment_cartoon fragment = new Fragment_cartoon();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_cartoon, container, false);
        init();
        init2();
        init3(inflate);
        RecyclerView recyclerView = inflate.findViewById(R.id.recyclerview_content);
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        ThinkAdapter adapter = new ThinkAdapter(list);
        recyclerView.setAdapter(adapter);
        RecyclerView recyclerView2 = inflate.findViewById(R.id.recyclerview_think);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(activity);
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(layoutManager2);
        ThinkAdapter2 adapter2 = new ThinkAdapter2(list2);
        recyclerView2.setAdapter(adapter2);
        initData();
        initView(inflate);
        return inflate;
    }



    private void init3(View inflate) {
        viewPager2 = inflate.findViewById(R.id.fragment_rebang);
        fragmentList = new ArrayList<>();
        fragmentList.add(new View_hot("热门番剧"));
        fragmentList.add(new View_hot("热门国创"));
        fragmentList.add(new View_hot("热门国创相关"));
        myPageAdapter = new MyPagerAdapter((FragmentActivity) activity,fragmentList);
        viewPager2.setOffscreenPageLimit(2);
        viewPager2.setClipToPadding(false);

        viewPager2.setPadding(0,0,100,0);
        MarginPageTransformer pageTransformer = new MarginPageTransformer(20);
        viewPager2.setPageTransformer(pageTransformer);
        viewPager2.setAdapter(myPageAdapter);
    }

    private void init2() {
        for(int i = 0;i < 7; i++){
            list2.add(new Think2("更新至第6话","国王排名","550.7万追番"));
        }
    }

    private void init() {
        Think think1 = new Think(R.drawable.quanbnr,"全部内容");
        Think think2 = new Think(R.drawable.fanj,"番剧");
        Think think3 = new Think(R.drawable.guoc,"国创");
        Think think4 = new Think(R.drawable.shijb,"国创导视");
        Think think5 = new Think(R.drawable.guocds,"发布会");
        Think think6 = new Think(R.drawable.xinf,"十月新番");
        Think think7 = new Think(R.drawable.tongnzq,"童年专区");
        Think think8 = new Think(R.drawable.yiqk,"一起看");

        list.add(think1);
        list.add(think2);
        list.add(think3);
        list.add(think4);
        list.add(think5);
        list.add(think6);
        list.add(think7);
        list.add(think8);

    }

    private void initData() {
        imagePath = new ArrayList<>();
        imageTitle = new ArrayList<>();
        imagePath.add(R.drawable.other);
        imagePath.add(R.drawable.other);
        imagePath.add(R.drawable.other);
        imageTitle.add("我是海鸟一号");
        imageTitle.add("我是海鸟二号");
        imageTitle.add("我是海鸟三号");
    }

    private void initView(View inflate) {
        mMyImageLoader = new Fragment_cartoon.MyImageLoader();
        mBanner = inflate.findViewById(R.id.mBanner);
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
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
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