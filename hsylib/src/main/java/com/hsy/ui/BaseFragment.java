package com.hsy.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.hsy.utils.AppToast;


/**
 * Created by hsy on 2017/1/13.
 * Fragment基类
 */

public class BaseFragment extends Fragment {

    protected Activity mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        super.onCreate(savedInstanceState);
    }

    protected void showToast(String text) {
        AppToast.showToast(getActivity(), text);
    }

    protected void showToast(int resourceId) {
        AppToast.showToast(getActivity(), resourceId);
    }
}
