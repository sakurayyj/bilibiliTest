package com.example.mybilibili;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class Fragment_One extends Fragment {

    private String string;

    public Fragment_One(String string) {
        this.string = string;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment__one, container, false);
        //TextView txt = inflate.findViewById(R.id.txt);
        //txt.setText(string);
        return inflate;
    }
}