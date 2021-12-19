package com.example.mybilibili.dongtai;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mybilibili.R;
import com.example.mybilibili.adapter.MyPagerAdapter;
import com.example.mybilibili.shouye.Fragment_cartoon;
import com.example.mybilibili.shouye.Fragment_hot;
import com.example.mybilibili.shouye.Fragment_live;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class DynamicFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private MyPagerAdapter myPageAdapter;
    private ArrayList<Fragment> fragmentList;
    private String[] strs = {"视频","综合"};
    private Activity activity;
    private SwipeRefreshLayout swipeRefresh;

    public DynamicFragment(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_dynamic, container, false);
//        swipeRefresh = (SwipeRefreshLayout)inflate.findViewById(R.id.swip_refresh);
//        swipeRefresh.setColorSchemeColors(R.color.black);
//        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                refresh(inflate);
//            }
//        });
        init(inflate);
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
                        init(inflate);
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }


    private void init(View inflate) {
        viewPager2 = inflate.findViewById(R.id.view_pager2);
        tabLayout = inflate.findViewById(R.id.tab_layout2);
        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment_video());
        fragmentList.add(new Fragment_synthesize(activity));

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

}