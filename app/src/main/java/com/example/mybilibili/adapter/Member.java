package com.example.mybilibili.adapter;

import android.text.Layout;

import androidx.recyclerview.widget.RecyclerView;

public class Member {
    private RecyclerView view1;
    private RecyclerView view2;
    private RecyclerView view3;

    public Member(RecyclerView view1, RecyclerView view2, RecyclerView view3) {
        this.view1 = view1;
        this.view2 = view2;
        this.view3 = view3;
    }

    public RecyclerView getView1() {
        return view1;
    }

    public void setView1(RecyclerView view1) {
        this.view1 = view1;
    }

    public RecyclerView getView2() {
        return view2;
    }

    public void setView2(RecyclerView view2) {
        this.view2 = view2;
    }

    public RecyclerView getView3() {
        return view3;
    }

    public void setView3(RecyclerView view3) {
        this.view3 = view3;
    }
}
