package com.yanzi.resume.util;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


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
     */
    public static int dip2Px(int dip) {
        float density = getResources().getDisplayMetrics().density;
        int   px      = (int) ( dip * density + .5f );
        return px;
    }

    /**
     * px-->dip
     */
    public static int px2Dip(int px) {
        float density = getResources().getDisplayMetrics().density;
        int   dp      = (int) ( px / density + .5f );
        return dp;
    }

    public static void startActivity(Context context,Class clazz){
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

    //得到图片
    public static Bitmap getBitmap(Context context,Uri uri){
        Bitmap bitmap;
        try {
            bitmap = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return bitmap;
    }

    /** 保存方法 */
    public static void saveBitmap(Bitmap bitmap) {
        String PIC_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
        File f = new File(PIC_PATH, "temp.jpeg");
        if (f.exists()) {
            f.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(f);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}







