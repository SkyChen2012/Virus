package com.benson.views.ViewPager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * com.benson.virus.ViewPager
 * Created by Benson on 2017/12/18-上午11:02.
 */

public class AdapterViewpager extends PagerAdapter{

    private List<View> mViewList;

    public AdapterViewpager(List<View> mViewList) {
        this.mViewList = mViewList;
    }


    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        container.addView(mViewList.get(position));
        return mViewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(mViewList.get(position));

    }
}
