package com.hsy.utils;

/**
 * Created by hsy on 2017/1/13.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.Arrays;

/**
 * User: Hubery Huang(377907757@qq.com)
 * Date: 2016-04-08
 * Time: 17:06
 */
public class FragmUtils {

    private final int mRes;

    public final static String Current_INDEX_TAG = "current:fragemt";

    /**
     * framents 's class name
     */
    String mFragms[];

    private String mCurrentContentTag;

    private FragmentManager mFragmentManager;
    private FragmentActivity mContext;
    private Fragment tagFragment;
    private Fragment mCurrentFragment;
    private int mIndex;

    public FragmUtils(FragmentActivity fragmentActivity, int res, String[] fragms) {
        mRes = res;
        mContext = fragmentActivity;
        mFragms = fragms;
        mFragmentManager = fragmentActivity.getSupportFragmentManager();
    }


    public void transacionFragmentByName(String name) {
        mIndex = Arrays.asList(mFragms).indexOf(name);
        transacionfragmentByIndex(mIndex);
    }

    /**
     * 描述：开始转化fragment
     *
     * @param pos
     * @return void
     */
    public void transacionfragmentByIndex(final int pos) {
        mIndex = pos;
        String tag = mFragms[pos];
        // 如果还是当前fragment，直接返回
        if (tag.equals(mCurrentContentTag)) {
            return;
        }

        FragmentTransaction ft = mFragmentManager.beginTransaction();
        if (mCurrentContentTag != null) {
            Fragment fragment = mFragmentManager.findFragmentByTag(mCurrentContentTag);
            //隐藏旧的Fragment
            if (fragment != null) {
                ft.hide(fragment);
            }
        }
        tagFragment = mFragmentManager.findFragmentByTag(tag);
        //显示新Fragment
        if (tagFragment != null) {
            ft.show(tagFragment);
        } else {
            //初次创建
            tagFragment = Fragment.instantiate(mContext, mFragms[pos]);
            ft.add(mRes, tagFragment, tag);
        }
        mCurrentFragment = (Fragment) tagFragment;

        // ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();

        mCurrentContentTag = tag;

    }

    /**
     * 跳轉到一個fragment
     *
     * @param fragment
     */
    public void transacionfragment(Fragment fragment, Bundle argument) {
        if (fragment == null) {
            return;
        }

        FragmentTransaction ft = mFragmentManager.beginTransaction();
        if (tagFragment != null) {
            ft.hide(tagFragment);
        }
        ft.show(fragment);
        //ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commitAllowingStateLoss();

        mCurrentContentTag = fragment.getClass().getName();

    }

    /**
     * 通過參數跳轉到一個fragment
     *
     * @param pos
     * @param argument
     */
    public FragmUtils transacionfragmentByIndexWithArgument(int pos, Bundle argument) {
        String tag = mFragms[pos];
        Fragment fragment = mFragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            fragment = Fragment.instantiate(mContext, mFragms[pos]);
        }
        transacionfragment(fragment, argument);
        return this;
    }

    public int getCurrentIndex() {
        return mIndex;
    }

    public Fragment getCurrentFragment() {
        return mCurrentFragment;
    }
}
