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
        fragmentList.add(new View_hot("????????????"));
        fragmentList.add(new View_hot("????????????"));
        fragmentList.add(new View_hot("??????????????????"));
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
            list2.add(new Think2("????????????6???","????????????","550.7?????????"));
        }
    }

    private void init() {
        Think think1 = new Think(R.drawable.quanbnr,"????????????");
        Think think2 = new Think(R.drawable.fanj,"??????");
        Think think3 = new Think(R.drawable.guoc,"??????");
        Think think4 = new Think(R.drawable.shijb,"????????????");
        Think think5 = new Think(R.drawable.guocds,"?????????");
        Think think6 = new Think(R.drawable.xinf,"????????????");
        Think think7 = new Think(R.drawable.tongnzq,"????????????");
        Think think8 = new Think(R.drawable.yiqk,"?????????");

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
        imageTitle.add("??????????????????");
        imageTitle.add("??????????????????");
        imageTitle.add("??????????????????");
    }

    private void initView(View inflate) {
        mMyImageLoader = new Fragment_cartoon.MyImageLoader();
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