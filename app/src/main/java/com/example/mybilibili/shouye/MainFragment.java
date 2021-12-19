package com.example.mybilibili.shouye;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mybilibili.R;
import com.example.mybilibili.activity.MainActivity;
import com.example.mybilibili.activity.WelcomeActivity;
import com.example.mybilibili.adapter.MyPagerAdapter;
import com.example.mybilibili.wode.Fragment_my;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainFragment extends Fragment implements View.OnClickListener {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private MyPagerAdapter myPageAdapter;
    private ArrayList<Fragment> fragmentList;
    private String[] strs = {"直播","推荐","热门","动画","影视","建党百年"};
    private Activity activity;
    private CircleImageView cv;
    private FragmentManager fragmentManager;
    private BottomNavigationView navigationView;

    public MainFragment(Activity activity,BottomNavigationView navigationView,FragmentManager fragmentManager) {
        this.activity = activity;
        this.navigationView = navigationView;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_main, container, false);

        cv = inflate.findViewById(R.id.touxiang);
        cv.setOnClickListener(this);
        init(inflate);
        return inflate;
    }






    private void init(View inflate) {
        viewPager2 = inflate.findViewById(R.id.view_pager);
        tabLayout = inflate.findViewById(R.id.tab_layout);
        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment_live("111",activity,fragmentManager));
        fragmentList.add(new Fragment_live("222",activity,fragmentManager));
        fragmentList.add(new Fragment_hot());
        fragmentList.add(new Fragment_cartoon(activity));
        fragmentList.add(new Fragment_movie(activity));
        fragmentList.add(new Fragment_live("555",activity,fragmentManager));
        myPageAdapter = new MyPagerAdapter((FragmentActivity) activity,fragmentList);
        viewPager2.setAdapter(myPageAdapter);
        viewPager2.setCurrentItem(1);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {
                tab.setText(strs[position]);
            }
        }).attach();
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.touxiang:
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(view.getId(),new Fragment_my());
                //transaction.commit();
                navigationView.setSelectedItemId(R.id.navigation_myview);
        }
    }
}
