package com.benson.views.ViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * com.benson.virus.ViewPager
 * Created by Benson on 2017/12/18-上午11:04.
 */

public class AdapterFragment extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public AdapterFragment(FragmentManager fm, List<Fragment> mFragments) {

        super(fm);
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {//必须实现
        return mFragments.get(position);
    }

    @Override
    public int getCount() {//必须实现
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {//选择性实现
        return mFragments.get(position).getClass().getSimpleName();
    }
}
