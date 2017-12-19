package com.benson.views.ViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * com.benson.virus.ViewPager
 * Created by Benson on 2017/12/18-下午2:53.
 */

public class QuickFragmentPageAdapter <T extends Fragment> extends FragmentPagerAdapter {

    private List<T> mList;
    private String[] mStrings;

    public QuickFragmentPageAdapter(FragmentManager fm, List<T> list, String[] titles) {

        super(fm);
        mList = list;
        mStrings = titles;

    }

    @Override
    public Fragment getItem(int position) {

        return mList.get(position);
    }

    @Override
    public int getCount() {

        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return mStrings == null ? super.getPageTitle(position) : mStrings[position];
    }
}
