package com.yanzi.resume.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.yanzi.resume.R;

/**
 * 创建者        黄燕
 * 创建时间      2016/10/20 15:46
 * 描述          ${Activity基类}
 *
 * 更新者         $Author$
 * 跟新时间       $Date$
 * 跟新描述       ${TODO}
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {
    private ResumeApplication application;
    private BaseActivity oContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局id
        setContentView(getLayoutId());
        //状态栏颜色设置
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//因为不是所有的系统都可以设置颜色的，在4.4以下就不可以。。有的说4.1，所以在设置的时候要检查一下系统版本是否是4.1以上
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.navigation_blue));
        }

        initView();
        initData();
        initListener();
        regCommBtn();

        if (application == null) {
            // 得到Application对象
            application = (ResumeApplication) getApplication();
        }
        oContext = this;// 把当前的上下文对象赋值给BaseActivity
    }

    //处理公用按钮
    private void regCommBtn() {
        View back = findViewById(R.id.back);
        if (back != null) {
            back.setOnClickListener(this);
        }
    }

    //setdata
    protected abstract void initData();

    //setadapter  setlistener
    protected abstract void initListener();

    //初始化view
    protected abstract void initView();

    //获取布局id
    protected abstract int getLayoutId();

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            default:
                processClick(v); //处理除了back按钮之外的点击事件
                break;
        }
    }
    //处理除了back按钮之外的点击事件
    protected abstract void processClick(View v);
}
