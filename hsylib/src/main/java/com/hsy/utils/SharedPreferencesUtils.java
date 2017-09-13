package com.hsy.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.google.gson.Gson;

import java.io.IOException;

/**
 * SharedPreferences操作工具包<br>
 * <b>说明</b> 本工具包只能在单进程项目下使用，多进程共享请使用如下demo的两行代码重写: <br>
 * Context otherContext = c.createPackageContext( "com.android.contacts",
 * Context.CONTEXT_IGNORE_SECURITY); <br>
 * SharedPreferences sp = otherContext.getSharedPreferences( "my_file",
 * Context.MODE_MULTI_PROCESS);<br>
 * <b>创建时间</b> 2014-7-27
 */
public class SharedPreferencesUtils {
    public static String fileName = "sharpin_date";

    private static Context mContext;
    public static void init(Context context){
        mContext = context;
    }

    public static void write(String k, int v) {
        SharedPreferences preference = mContext.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        Editor editor = preference.edit();
        editor.putInt(k, v);
        editor.commit();
    }

    public static void write(String k,
                             boolean v) {
        SharedPreferences preference = mContext.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        Editor editor = preference.edit();
        editor.putBoolean(k, v);
        editor.commit();
    }

    public static void write(String k,
                             String v) {
        SharedPreferences preference = mContext.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        Editor editor = preference.edit();
        editor.putString(k, v);
        editor.commit();
    }

    public static void write(String k,
                             float v) {
        SharedPreferences preference = mContext.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        Editor editor = preference.edit();
        editor.putFloat(k, v);
        editor.commit();
    }

   /* */

    /**
     * 存储double，其实是存String类型
     *
     * @param k
     * @param v
     */
    public static void write(String k,
                             double v) {
        SharedPreferences preference = mContext.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        Editor editor = preference.edit();
        editor.putString(k, v + "");
        editor.commit();
    }

    /**
     * 保存list
     *
     * @param k
     * @param v
     */
    public static <T> void write(String k,
                                 T v) {
        SharedPreferences preference = mContext.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        Editor editor = preference.edit();
        try {
            String liststr = Object2String(v);
            AppLog.getInstance().v("liststr:" + liststr);
            editor.putString(k, liststr);
            editor.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int readInt(String k) {
        SharedPreferences preference = mContext.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getInt(k, 0);
    }

    public static int readInt(String k,
                              int defv) {
        SharedPreferences preference = mContext.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getInt(k, defv);
    }

//    /**
//     * 获取的String 强转为double
//     * @param context
//     * @param k
//     * @return
//     */
//    public static double readDouble(Context context, String k) {
//        SharedPreferences preference = context.getSharedPreferences(fileName,
//                Context.MODE_PRIVATE);
//        return StringUtils.toDouble(preference.getString(k, "0"));
//    }

    public static float readFloat(String k,
                                  float defv) {
        SharedPreferences preference = mContext.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getFloat(k, defv);
    }

    public static boolean readBoolean(String k) {
        SharedPreferences preference = mContext.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getBoolean(k, false);
    }

    public static boolean readBoolean(
            String k, boolean defBool) {
        SharedPreferences preference = mContext.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getBoolean(k, defBool);
    }


    public static String readString(String k) {
        SharedPreferences preference = mContext.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getString(k, null);
    }

    public static String readString(String k,
                                    String defV) {
        SharedPreferences preference = mContext.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getString(k, defV);
    }

    public static <T> T readObject(String k, Class<T> object) {

        SharedPreferences preference = mContext.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        String liststr = preference.getString(k, "");
        AppLog.getInstance().v("liststr:2" + liststr);
        return String2Object(liststr, object);
    }

    public static void remove(Context context, String k) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        Editor editor = preference.edit();
        editor.remove(k);
        editor.commit();
    }

    public static void clean(Context cxt) {
        SharedPreferences preference = cxt.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        Editor editor = preference.edit();
        editor.clear();
        editor.commit();
    }

    public static <T> String Object2String(T object)
            throws IOException {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    @SuppressWarnings("unchecked")
    public static <T> T String2Object(String str, Class<T> object) {
        Gson gson = new Gson();
        return gson.fromJson(str, object);
    }
}