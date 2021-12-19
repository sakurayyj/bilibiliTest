package com.example.mybilibili.shouye;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.mybilibili.R;
import com.example.mybilibili.adapter.MovieAdapter;
import com.example.mybilibili.adapter.MyPagerAdapter;
import com.example.mybilibili.adapter.Think;
import com.example.mybilibili.adapter.Think2;
import com.example.mybilibili.adapter.ThinkAdapter;
import com.example.mybilibili.adapter.ThinkAdapter2;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Fragment_movie extends Fragment{




   private List<Think> list = new ArrayList<>();
   private List<Think2> list2 = new ArrayList<>();
   private List<String> list3 = new ArrayList<>();
   private Activity activity;
   private Banner mBanner;
   private Fragment_movie.MyImageLoader mMyImageLoader;
   private ArrayList<Integer> imagePath;
   private ArrayList<String> imageTitle;
   private ViewPager2 viewPager2;
   private MyPagerAdapter myPageAdapter;
   private ArrayList<Fragment> fragmentList;
   private String videoPath;
   public Fragment_movie(Activity activity) {
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
      View inflate = inflater.inflate(R.layout.fragment_movie, container, false);
      init();
      init2();
      init3();
      initRec(inflate);
      initBanner();
      initView(inflate);
      return inflate;
   }

   private void init3() {
      for(int i = 0;i < 5; i++){
         list3.add("android.resource://" + activity.getPackageName() + "/" + R.raw.video3);
      }
   }

   private void initRec(View inflate) {
      RecyclerView recyclerView = inflate.findViewById(R.id.recyclerview_content1);
      RecyclerView recyclerView2 = inflate.findViewById(R.id.recyclerview_think1);
      RecyclerView recyclerView3 = inflate.findViewById(R.id.recyclerview_think2);
      RecyclerView recyclerView4 = inflate.findViewById(R.id.rec_video);
      LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
      LinearLayoutManager layoutManager2 = new LinearLayoutManager(activity);
      LinearLayoutManager layoutManager3 = new LinearLayoutManager(activity);
      LinearLayoutManager layoutManager4 = new LinearLayoutManager(activity);
      layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
      layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
      layoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
      recyclerView.setLayoutManager(layoutManager);
      recyclerView2.setLayoutManager(layoutManager2);
      recyclerView3.setLayoutManager(layoutManager3);
      recyclerView4.setLayoutManager(layoutManager4);
      ThinkAdapter adapter = new ThinkAdapter(list);
      ThinkAdapter2 adapter2 = new ThinkAdapter2(list2);
      MovieAdapter adapter3 = new MovieAdapter(activity,list3);
      recyclerView.setAdapter(adapter);
      recyclerView2.setAdapter(adapter2);
      recyclerView3.setAdapter(adapter2);
      recyclerView4.setAdapter(adapter3);
   }



   private void init2() {
      for(int i = 0;i < 7; i++){
         list2.add(new Think2("更新至第6话","国王排名","550.7万追番"));
      }
   }

   private void init() {
      Think think1 = new Think(R.drawable.quanbnr,"全部内容");
      Think think2 = new Think(R.drawable.fanj,"舞千年");
      Think think3 = new Think(R.drawable.guoc,"电影");
      Think think4 = new Think(R.drawable.shijb,"电视剧");
      Think think5 = new Think(R.drawable.guocds,"纪录片");
      Think think6 = new Think(R.drawable.xinf,"综艺");
      Think think7 = new Think(R.drawable.tongnzq,"热门榜单");
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

   private void initBanner() {
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
      mMyImageLoader = new Fragment_movie.MyImageLoader();
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