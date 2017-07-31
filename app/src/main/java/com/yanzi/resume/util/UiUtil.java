package com.yanzi.resume.util;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;


/**
 * 创建者     黄燕
 * 创建时间   2016/6/18 23:03
 * 描述	     处理UI相关的工具类，读取资源（文本、图片）
 *
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class UiUtil {

    private static Context mContext;
    private static Handler mHandler;

    public static void init(Context laPlayerApplication) {
        mContext = laPlayerApplication;
        mHandler = new Handler();
    }

    /**
     * 得到上下文
     */
    public static Context getContext(){
        return mContext;
    }

    /**
     * 提交一个任务
     */
    public static void post(Runnable runnable){
        mHandler.post(runnable);
    }

    /**
     * 延时提交一个任务
     */
    public static void postDelay(Runnable runnable,long delayTime){
        mHandler.postDelayed(runnable, delayTime);
    }

    /**
     * 移除一个任务
     */
    public static void removeTask(Runnable runnable){
        mHandler.removeCallbacks(runnable);
    }

    /**
    * 得到Resource对象
    */
    public static Resources getResources() {
        return getContext().getResources();
    }

    public static String[] getStringArray(int resId){
        return mContext.getResources().getStringArray(resId);
    }

    public static String getPackName() {
        return mContext.getPackageName();
    }


    //得到string.xml中的字符
    public static String getSring(int resId, Object formatArgs) {
        return mContext.getResources().getString(resId, formatArgs);
    }

    /**
    * 得到color.xml中的颜色值
    */
    public static int getColor(int resId) {
        return mContext.getResources().getColor(resId);
    }


    /**
     * dip-->px
     *
     * @param dip
     *
     * @return
     */
    public static int dip2Px(int dip) {
        // px/dp = density
        // px/(ppi/160) = px
        float density = getResources().getDisplayMetrics().density;//1.5
      //  int   ppi     = getResources().getDisplayMetrics().densityDpi;//240
        int   px      = (int) ( dip * density + .5f );
        return px;
    }

    /**
     * px-->dip
     *
     * @param px
     *
     * @return
     */
    public static int px2Dip(int px) {
        // px/dp = density
        float density = getResources().getDisplayMetrics().density;//1.5
        int   dp      = (int) ( px / density + .5f );
        return dp;
    }

    public static void startActivity(Context context,Class clazz){
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }
}







