package com.hsy.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hsy.R;


/**
 * Created by hsy on 2017/1/18.
 * App Title管理类
 */

public class BaseTitleActivity extends BaseActivity {

    private ImageView mLeftImage;
    private ImageView mRightImage;
    private TextView mTitleTxt;
    private TextView mRightTxt;

    private RelativeLayout mTitleLayout;
    private FrameLayout mContentLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.title_layout);

        mTitleLayout = (RelativeLayout) findViewById(R.id.title_layout);
        mContentLayout = (FrameLayout) findViewById(R.id.content_layout);
        mLeftImage = (ImageView) findViewById(R.id.left_image);
        mRightImage = (ImageView) findViewById(R.id.right_image);
        mRightTxt = (TextView) findViewById(R.id.right_txt);
        mTitleTxt = (TextView) findViewById(R.id.title_txt);

        mRightImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRightImageClick(v);
            }
        });
    }

    protected void setTitleBackgroundColor(int rID) {
        mTitleLayout.setBackgroundColor(getResources().getColor(rID));
    }

    protected void setLeftImageRes(int rId) {
        mLeftImage.setVisibility(View.VISIBLE);
        mLeftImage.setImageResource(rId);
    }

    protected void setRightImageRes(int rId) {
        mRightImage.setVisibility(View.VISIBLE);
        mRightImage.setImageResource(rId);
    }

    protected void setRightTxt(int rId) {
        mRightTxt.setVisibility(View.VISIBLE);
        mRightTxt.setText(getString(rId));
    }

    protected void setRightTxt(int rId, int colorId) {
        mRightTxt.setVisibility(View.VISIBLE);
        mRightTxt.setText(rId);
        mRightTxt.setTextColor(colorId);
    }

    public void setTitle(int rId) {
        mTitleTxt.setText(getString(rId));
    }

    public void setTitle(String str) {
        mTitleTxt.setText(str);
    }


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        View contentView = LayoutInflater.from(this).inflate(layoutResID, null);
        mContentLayout.addView(contentView);
    }

    public void onLeftImageClick(View view) {
        finish();
    }

    public void onRightTxtClick(View view) {

    }

    public void onRightImageClick(View view) {

    }
}
