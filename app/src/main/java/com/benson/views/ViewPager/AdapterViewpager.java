package com.benson.views.ViewPager;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * com.benson.virus.ViewPager
 * Created by Benson on 2017/12/18-上午11:02.
 */

public class AdapterViewpager extends PagerAdapter{

    private static final String Tag = "AdapterViewpager";
    private List<View> mViewList;
    private List<String> mTitleList;


    public AdapterViewpager(List<View> mViewList, List<String> mTitleList) {
        this.mViewList = mViewList;
        this.mTitleList = mTitleList;
    }


    @Override
    public int getCount() {
        if (mViewList != null){
            return mViewList.size();
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (mTitleList != null) {
            return mTitleList.get(position);
        }
        return super.getPageTitle(position);
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
