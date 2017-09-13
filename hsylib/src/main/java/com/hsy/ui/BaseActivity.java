package com.hsy.ui;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentActivity;

import com.hsy.R;
import com.hsy.utils.AppToast;
import com.jaeger.library.StatusBarUtil;


/**
 * Created by hsy on 2017/1/13.
 * Activity基类，常用工具的封装
 */

public class BaseActivity extends FragmentActivity {

    private static final int IN_RIGHT_TO_LEFT = 0x00;
    private static final int IN_BOTTOM_TO_TOP = 0x01;


    @Override
    public void startActivity(Intent intent) {
        // TODO Auto-generated method stub
        super.startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }

    protected void startActivity(Intent intent, int flag) {
        super.startActivity(intent);
        switch (flag) {

            case IN_RIGHT_TO_LEFT:
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
            case IN_BOTTOM_TO_TOP:
                overridePendingTransition(R.anim.abc_slide_in_bottom,
                        R.anim.abc_slide_out_top);
            default:
                break;
        }
    }

    public void startActivityNoAnim(Intent intent) {
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        super.startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
    }

    protected void showToast(String text) {
        AppToast.showToast(this, text);
    }

    protected void showToast(int resourceId) {
        AppToast.showToast(this, resourceId);
    }

    protected void setStatusColor(int rId){
        StatusBarUtil.setColorNoTranslucent(this, getResources().getColor(rId));
    }

}
