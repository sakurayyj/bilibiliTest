package com.example.mybilibili.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mybilibili.dongtai.DynamicFragment;
import com.example.mybilibili.member.MemberFragment;
import com.example.mybilibili.others.PopUtils;
import com.example.mybilibili.wode.Fragment_my;
import com.example.mybilibili.shouye.MainFragment;
import com.example.mybilibili.R;
import com.example.mybilibili.adapter.MyPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener ,View.OnClickListener {

    private BottomNavigationView navigationView;
    private ArrayList<Fragment> fragmentList;
    private ViewPager2 viewPager2;
    private FragmentManager fragmentManager;
    private ImageView addMore;
    private Animation operatingAnim;
    private PopupWindow mPopWindow;
    public int flag = 1;
    public PopupWindow popupWindow;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        setWindowStatusBarColor(this ,R.color.transparent);
        setWindowLightStatusBar(this,true);
    }


    private void initData() {
        addMore = findViewById(R.id.add_more);
        //addMore.setImageResource(R.drawable.add);
        navigationView = findViewById(R.id.nav_view);
        fragmentManager = getSupportFragmentManager();
        fragmentList = new ArrayList<>();
        fragmentList.add(new MainFragment(MainActivity.this,navigationView,fragmentManager));
        //fragmentList.add(new MainFragment(MainActivity.this,navigationView,fragmentManager));
        fragmentList.add(new DynamicFragment(MainActivity.this));
        fragmentList.add(new MemberFragment(MainActivity.this));
        fragmentList.add(new MemberFragment(MainActivity.this));
        fragmentList.add(new Fragment_my());
        viewPager2 = findViewById(R.id.fragment_main);
        viewPager2.setAdapter(new MyPagerAdapter(this, fragmentList));
        navigationView.setOnNavigationItemSelectedListener(this);
        navigationView.setSelectedItemId(R.id.navigation_home);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                navigationView.setSelectedItemId(navigationView.getMenu().getItem(position).getItemId());
            }
        });

//        operatingAnim = AnimationUtils.loadAnimation(this, R.anim.tip);
//        LinearInterpolator lin = new LinearInterpolator();
//        operatingAnim.setInterpolator(lin);
//        if (operatingAnim != null) {
//            addMore.startAnimation(operatingAnim);
//        }
//        addMore.clearAnimation();
    }

    private void showPopupMenu(View view) {
        // View当前PopupMenu显示的相对View的位置
        PopupMenu popupMenu = new PopupMenu(this, view, Gravity.CENTER);
        // menu布局
        popupMenu.getMenuInflater().inflate(R.menu.add_more, popupMenu.getMenu());
        // menu的item点击事件
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        // PopupMenu关闭事件
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
            }
        });

        popupMenu.show();
    }
//    public void onConfigurationChanged(Configuration newConfig) {
//
//        super.onConfigurationChanged(newConfig);
//
//        if (operatingAnim != null && addMore != null && operatingAnim.hasStarted()) {
//            addMore.clearAnimation();
//            addMore.startAnimation(operatingAnim);
//        }
//    }

    private void showPopupWindow() {
//        View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.popuplayout, null);
//        mPopWindow = new PopupWindow(contentView);
//        mPopWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
//        mPopWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
//

//
//        mPopWindow.showAsDropDown(addMore);
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = layoutInflater.inflate(R.layout.popuplayout,null);
        View layout = layoutInflater.inflate(R.layout.activity_main,null);
        popupWindow = new PopupWindow(customView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.showAtLocation(layout,Gravity.BOTTOM,0,-50);
//        View pop = LayoutInflater.from(MainActivity.this).inflate(R.layout.popuplayout, null, false);
//        View v = ((ViewGroup) (getWindow().getDecorView().findViewById(android.R.id.content))).getChildAt(0);
//        PopUtils popUtils = new PopUtils(v, pop);
//        popUtils.showPopY(-2070);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()){
            case R.id.navigation_home:
                viewPager2.setCurrentItem(0);
                return true;
            case R.id.navigation_dashboard:
                viewPager2.setCurrentItem(1);
                return true;
            case R.id.navigation_add:
                showPopupMenu(addMore);
                /*if(flag == 1){
                    showPopupWindow();
                    //initTxt();
                    flag = 0;
                }else{
                    popupWindow.dismiss();
                    flag = 1;
                }*/
                //viewPager2.setCurrentItem(2);
                return true;
            case R.id.navigation_notifications:
                viewPager2.setCurrentItem(3);
                return true;
            case R.id.navigation_myview:
                viewPager2.setCurrentItem(4);
                return true;
        }
        return true;

    }

    private void initTxt() {
        ImageView img1 = findViewById(R.id.more_live);
        ImageView img2 = findViewById(R.id.more_photo);
        ImageView img3 = findViewById(R.id.more_shangchuan);
        ImageView img4 = findViewById(R.id.more_moban);

        TextView tv1 = findViewById(R.id.m_live);
        TextView tv2 = findViewById(R.id.m_photo);
        TextView tv3 = findViewById(R.id.m_shangchuan);
        TextView tv4 = findViewById(R.id.m_mbcz);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);

        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
    }

    //传入Activity，和修改后的颜色
    public static void setWindowStatusBarColor(Activity activity, int colorResId) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                //顶部状态栏
                window.setStatusBarColor(activity.getResources().getColor(colorResId));
                //底部导航栏
                //window.setNavigationBarColor(activity.getResources().getColor(colorResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //设置字体颜色，true表示黑色
    public static void setWindowLightStatusBar(Activity activity,boolean shouldChangeStatusBarTintToDark){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decor = activity.getWindow().getDecorView();
            if (shouldChangeStatusBarTintToDark) {
                decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else {
                decor.setSystemUiVisibility(0);
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.more_live:
            case R.id.m_live:
                Toast.makeText(this, "直播", Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            case R.id.more_photo:
            case R.id.m_photo:
                Toast.makeText(this,"拍摄",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            case R.id.more_shangchuan:
            case R.id.m_shangchuan:
                Toast.makeText(this,"上传",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
            case R.id.more_moban:
            case R.id.m_mbcz:
                Toast.makeText(this,"模板创作",Toast.LENGTH_SHORT).show();
                mPopWindow.dismiss();
                break;
        }

    }
}