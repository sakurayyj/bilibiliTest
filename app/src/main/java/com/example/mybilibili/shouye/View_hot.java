package com.example.mybilibili.shouye;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mybilibili.R;


public class View_hot extends Fragment {

    private String str;
    private TextView textView;

    public View_hot(String str) {
        // Required empty public constructor
        this.str = str;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_view_hot, container, false);
        textView = inflate.findViewById(R.id.which_hot);
        textView.setText(str);
        return inflate;
    }
}