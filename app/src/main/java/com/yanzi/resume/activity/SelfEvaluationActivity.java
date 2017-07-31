package com.yanzi.resume.activity;

import android.view.View;
import android.widget.TextView;

import com.yanzi.resume.R;
import com.yanzi.resume.base.BaseActivity;

/**
 * 创建者     黄燕
 * 创建时间   2017/7/23 18:58
 * 描述	      ${TODO}
 *
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class SelfEvaluationActivity extends BaseActivity{
    //    @BindView(R.id.navigation_title)
    TextView navigation_title;

    @Override
    protected void initData() {
        //        ButterKnife.bind(this);
        navigation_title.setText("自我评价");
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        navigation_title = (TextView) findViewById(R.id.navigation_title);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_self_evaluation;
    }

    @Override
    protected void processClick(View v) {

    }
}
