package com.example.mybilibili.shouye;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mybilibili.R;

import static com.example.mybilibili.others.RoundRectImageView.getRoundBitmapByShader;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link Fragment_hot#newInstance} factory method to
// * create an instance of this fragment.
// *
// */
public class Fragment_hot extends Fragment {

//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//
//    private String mParam1;
//    private String mParam2;
//
//    public static Fragment_hot newInstance(String param1, String param2) {
//        Fragment_hot fragment = new Fragment_hot();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
    public Fragment_hot() {
        // Required empty public constructor
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_hot, container, false);
        init(inflate);
        return inflate;
    }

    private void init(View inflate) {
        ImageView iv1 = inflate.findViewById(R.id.photo1);
        ImageView iv2 = inflate.findViewById(R.id.photo2);
        ImageView iv3 = inflate.findViewById(R.id.photo3);
        ImageView iv4 = inflate.findViewById(R.id.photo4);
        ImageView iv5 = inflate.findViewById(R.id.photo5);
        ImageView iv6 = inflate.findViewById(R.id.photo6);
        ImageView iv7 = inflate.findViewById(R.id.photo7);
        ImageView iv8 = inflate.findViewById(R.id.photo8);
        ImageView iv9 = inflate.findViewById(R.id.photo9);
        ImageView iv10 = inflate.findViewById(R.id.photo10);
        ImageView iv11 = inflate.findViewById(R.id.photo11);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.other);
        Bitmap outBitmap =getRoundBitmapByShader(bitmap, 500,300,20, 3);
        iv1.setImageBitmap(outBitmap);
        iv2.setImageBitmap(outBitmap);
        iv3.setImageBitmap(outBitmap);
        iv4.setImageBitmap(outBitmap);
        iv5.setImageBitmap(outBitmap);
        iv6.setImageBitmap(outBitmap);
        iv7.setImageBitmap(outBitmap);
        iv8.setImageBitmap(outBitmap);
        iv9.setImageBitmap(outBitmap);
        iv10.setImageBitmap(outBitmap);
        iv11.setImageBitmap(outBitmap);
    }
}