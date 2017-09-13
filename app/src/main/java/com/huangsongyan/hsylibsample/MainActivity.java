package com.huangsongyan.hsylibsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hsy.utils.AppLog;
import com.jaeger.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppLog.getInstance().v("use lib");
        StatusBarUtil.setTranslucent(this);
    }
}
