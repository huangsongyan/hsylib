package com.hsy.common;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public abstract class AppAdapter<T> extends CommomAdapter<T> {


    public AppAdapter(Context context) {
        super(context);
    }

    public AppAdapter(Context context, List<T> data){
        super(context,data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext,convertView,parent,getLayoytId(),position);
        convert(holder,(T)getItem(position),position);
        return holder.getConvertView();
    }

    public abstract @LayoutRes int getLayoytId();
}
