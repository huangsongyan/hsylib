package com.hsy.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.hsy.R;
import com.hsy.utils.AppToast;


/**
 * Created by hsy on 2017/1/13.
 * Fragment基类
 */

public class BaseFragment extends Fragment {

    protected Activity mContext;

    private static final int IN_RIGHT_TO_LEFT = 0x00;
    private static final int IN_BOTTOM_TO_TOP = 0x01;

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


    @Override
    public void startActivity(Intent intent) {
        // TODO Auto-generated method stub
        super.startActivity(intent);
        if (mContext != null) {
            mContext.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }

    }

    protected void startActivity(Intent intent, int flag) {
        super.startActivity(intent);
        switch (flag) {

            case IN_RIGHT_TO_LEFT:
                if (mContext != null) {
                    mContext.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                }
                break;
            case IN_BOTTOM_TO_TOP:
                if (mContext != null) {
                    mContext.overridePendingTransition(R.anim.abc_slide_in_bottom,
                            R.anim.abc_slide_out_top);
                }
            default:
                break;
        }
    }
}
