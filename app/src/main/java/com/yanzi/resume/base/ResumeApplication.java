package com.yanzi.resume.base;

import android.app.Application;

import com.yanzi.resume.util.UiUtil;

/**
 * 创建者     黄燕
 * 创建时间   2017/7/23 16:00
 * 描述	      ${TODO}
 *
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public  class ResumeApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UiUtil.init(this);
    }
}