package com.yanzi.resume.activity;

import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yanzi.resume.R;
import com.yanzi.resume.base.BaseActivity;
import com.yanzi.resume.beans.ProjectExperienceEntity;
import com.yanzi.resume.util.UiUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者     黄燕
 * 创建时间   2017/7/23 19:57
 * 描述	      ${项目经验界面}
 *
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class ProjectExperienceActivity extends BaseActivity {
    private TextView                   navigation_title;
    private RecyclerView               mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private int screen_width;

    @Override
    protected void initData() {
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        screen_width = metric.widthPixels;     // 屏幕宽度（像素）

        //        ButterKnife.bind(this);
        navigation_title.setText("项目经验");

        //创建现行LinearLayoutManager
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置LayoutMananger
        mRecyclerView.setLayoutManager(mLayoutManager);
        //设置item的动画，可以不设置
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        //设置Adapter
        mRecyclerView.setAdapter(new MyAdapter(initDatas()));

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        navigation_title = (TextView) findViewById(R.id.navigation_title);
        mRecyclerView = (RecyclerView) findViewById(R.id.project_recycler_view);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_project_experience;
    }

    @Override
    protected void processClick(View v) {

    }

    private List<ProjectExperienceEntity> initDatas(){
        List<ProjectExperienceEntity> list = new ArrayList<>();
        String project_title1 = "项目(一)";
        String project_name1 = "项目名称：\t红辣椒VR";
        String project_description_content1 = UiUtil.getSring(R.string.project_description_content1,"");
        String project_technology_overview1 = UiUtil.getSring(R.string.project_technology_overview1,"");
        ProjectExperienceEntity entity1 = new ProjectExperienceEntity(project_title1,project_name1,project_description_content1,project_technology_overview1);
        list.add(entity1);

        String project_title2 = "项目(二)";
        String project_name2 = "项目名称：\t辣播";
        String project_description_content2 = UiUtil.getSring(R.string.project_description_content2,"");
        String project_technology_overview2 = UiUtil.getSring(R.string.project_technology_overview2,"");
        ProjectExperienceEntity entity2 = new ProjectExperienceEntity(project_title2,project_name2,project_description_content2,project_technology_overview2);
        list.add(entity2);

        return list;
    }

    class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        private List<ProjectExperienceEntity> items;

        public MyAdapter(List<ProjectExperienceEntity> items) {
            this.items = items;
        }

        /**
         * 创建ViewHolder的布局
         * @param parent
         * @param viewType
         * @return
         */
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_experience_recycleview_item, parent, false);
            return new ViewHolder(view);
        }

        /**
         * 通过ViewHolder将数据绑定到界面上进行显示
         * @param holder
         * @param position
         */
        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            ViewGroup.LayoutParams params = holder.mCardView.getLayoutParams();
            params.width = screen_width-UiUtil.dip2Px(25);
            holder.project_title.setText(items.get(position).getProject_title());
            holder.project_name.setText(items.get(position).getProject_name());
            holder.project_description_content.setText(items.get(position).getProject_description_content());
            holder.project_technology_overview.setText(items.get(position).getProject_technology_overview());
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView project_title;
            public TextView project_name;
            public TextView project_description_content;
            public TextView project_technology_overview;
            public CardView mCardView;

            public ViewHolder(View itemView) {
                super(itemView);
                mCardView = (CardView) itemView.findViewById(R.id.project_root);
                project_title = (TextView) itemView.findViewById(R.id.project_title);
                project_name = (TextView) itemView.findViewById(R.id.project_name);
                project_description_content = (TextView) itemView.findViewById(R.id.project_description_content);
                project_technology_overview = (TextView) itemView.findViewById(R.id.project_technology_overview);
            }
        }
    }
}
