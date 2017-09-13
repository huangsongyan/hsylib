package com.hsy.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * User: Hubery Huang(377907757@qq.com)
 * Date: 2016-04-06
 * Time: 10:53
 */
public class FragPagerAdapter extends FragmentPagerAdapter {

    // Fragment列表
    private List<Fragment> mFragmentsList;

    public FragPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public FragPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragmentsList = fragments;
    }



    @Override
    public int getCount() {
        return mFragmentsList != null ? mFragmentsList.size() : 0;
    }

    @Override
    public Fragment getItem(int arg0) {
        return mFragmentsList != null && mFragmentsList.size() > 0 ? mFragmentsList
                .get(arg0) : null;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

}