package com.benson.Activity.bannerLoader;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;


/**
 * com.benson.Activity.bannerLoader
 * Created by Benson on 2017/12/21-下午4:29.
 */


public class GlideImageLoader extends ImageLoader {


    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {

        Glide.with(context.getApplicationContext())
                .load(path)
                .into(imageView);

    }
}
