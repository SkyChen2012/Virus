package com.benson.Activity.XXFragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.benson.Activity.bannerLoader.GlideImageLoader;
import com.benson.virus.R;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * com.benson.Activity.XXFragment
 * Created by Benson on 2017/12/20-下午2:39.
 */


public class BannerFragment extends Fragment implements OnBannerListener,View.OnClickListener{

    private final static String Tag = "BannerFragment";

    private Banner banner;
    private View view;
    private List<?> images=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.layout2, container, false);

        initData();
        initView();

        return view;
    }

    private void initData() {

        String[] urls = getResources().getStringArray(R.array.url);

        images = new ArrayList(Arrays.asList(urls));

    }

    private void initView() {

        banner = (Banner)view.findViewById(R.id.banner);

        banner.setImages(images)
                .setImageLoader(new GlideImageLoader())
                .setOnBannerListener(this)
                .start();

        view.findViewById(R.id.btnBanner).setOnClickListener(this);


    }

    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(getContext(),"你点击了："+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

        Log.i(Tag,"startBtn.setOnClickListener。。。。");

//        Intent intent = new Intent(getActivity(),BannerActivty.class);
//        startActivity(intent);

    }
}
