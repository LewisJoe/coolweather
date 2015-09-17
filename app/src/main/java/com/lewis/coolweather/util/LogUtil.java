package com.lewis.coolweather.util;

import android.util.Log;

/**
 * Created by Administrator on 15-9-17.
 * 自定义日志工具类
 */
public class LogUtil {
    public final static int VERBOSE = 1;
    public final static int DEBUG = 2;
    public final static int INFO = 3;
    public final static int WARN = 4;
    public final static int ERROR = 5;
    public final static int NOTHING = 6;
    public final static int LEVEL = VERBOSE;

    /**
     * 打印verbose信息
     * @param tag
     * @param msg
     */
    public static void v(String tag,String msg){
        if (LEVEL <= VERBOSE){
            Log.v(tag,msg);
        }
    }

    /**
     * 打印debug信息
     * @param tag
     * @param msg
     */
    public static void d(String tag,String msg){
        if (LEVEL <= DEBUG){
            Log.d(tag,msg);
        }
    }

    /**
     * 打印info信息
     * @param tag
     * @param msg
     */
    public static void i(String tag,String msg){
        if (LEVEL <= INFO){
            Log.i(tag,msg);
        }
    }

    /**
     * 打印warn信息
     * @param tag
     * @param msg
     */
    public static void w(String tag,String msg){
        if (LEVEL <= WARN){
            Log.w(tag,msg);
        }
    }

    /**
     * 打印error信息
     * @param tag
     * @param msg
     */
    public static void e(String tag,String msg){
        if (LEVEL <= ERROR){
            Log.e(tag,msg);
        }
    }
}
