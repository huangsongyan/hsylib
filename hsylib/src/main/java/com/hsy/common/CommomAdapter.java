package com.hsy.common;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;


public abstract class CommomAdapter<T> extends BaseAdapter {

    protected List<T> mDatas;

    protected Context mContext;


    public CommomAdapter(Context context) {
        this.mContext = context;
    }


    public CommomAdapter(Context context, List<T> data){
        this.mContext = context;
        this.mDatas = data;
    }

    protected void setData(List<T> data){
        this.mDatas = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDatas==null?0:mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas==null?null:mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public abstract void convert(ViewHolder holder, T t, int position);

}
