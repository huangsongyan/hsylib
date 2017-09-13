package com.hsy.common;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public abstract class MultiItemAdapter<T> extends CommomAdapter<T> {

    public MultiItemAdapter(Context context) {
        super(context);
    }

    public MultiItemAdapter(Context context, List<T> data){
        super(context,data);
    }

    @Override
    public abstract int getViewTypeCount();

    @Override
    public int getItemViewType(int position) {
        return getItemViewType(position,mDatas.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext,convertView,parent,getLayoytId(position),position);
        convert(holder,(T)getItem(position),position);
        return holder.getConvertView();
    }

    public abstract int getItemViewType(int position, T t);

    public abstract @LayoutRes int getLayoytId(int position);
}
