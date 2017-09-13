package com.hsy.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by hsy on 2017/2/6.
 */

public class AppToast {

    private static Toast mToast;

    public static void showToast(Context context, String text) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void showToast(Context context, int id) {
        if (mToast == null) {
            mToast = Toast.makeText(context, id, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(id);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }
}
