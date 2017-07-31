package com.yanzi.resume.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yanzi.resume.view.CircleMenuLayout;
import com.yanzi.resume.R;
import com.yanzi.resume.util.UiUtil;


public class SiwenResumeActivity extends Activity {

	private CircleMenuLayout mCircleMenuLayout;
	private Context mContext = SiwenResumeActivity.this;

	private String[] mItemTexts = new String[]{"个人信息", "自我评价", "个人技能", "工作经历",
			"项目经验", "博客地址"};
	private int[]    mItemImgs  = new int[]{R.drawable.personalinformation,
			R.drawable.selfevaluation, R.drawable.personalskills,
			R.drawable.experience, R.drawable.projectexperience,
			R.drawable.blog};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//自已切换布局文件看效果
		setContentView(R.layout.activity_main02);
		//		setContentView(R.layout.activity_main);

		mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);
		mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);
		
		

		mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener()
		{
			
			@Override
			public void itemClick(View view, int pos)
			{
//				Toast.makeText(SiwenResumeActivity.this, mItemTexts[pos],
//						Toast.LENGTH_SHORT).show();
				switch (pos){
					case 0://个人信息
						UiUtil.startActivity(mContext,PersonalInformationActivity.class);
						break;
					case 1://自我评价
						UiUtil.startActivity(mContext,SelfEvaluationActivity.class);
						break;
					case 2://个人技能
						UiUtil.startActivity(mContext,PersonalSkillsActivity.class);
						break;
					case 3://工作经历
						UiUtil.startActivity(mContext,ExperienceActivity.class);
						break;
					case 4://项目经验
						UiUtil.startActivity(mContext,ProjectExperienceActivity.class);
						break;
					case 5://博客地址
						String uri = "http://blog.csdn.net/siwenyy";
						toBlog(uri);
						break;
				}

			}
			
			@Override
			public void itemCenterClick(View view)
			{
				Toast.makeText(SiwenResumeActivity.this,
						"你好,我是黄燕",
						Toast.LENGTH_SHORT).show();
				
			}
		});
		
	}

	private void toBlog(String uri) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(uri));
		startActivity(intent);
	}

}
