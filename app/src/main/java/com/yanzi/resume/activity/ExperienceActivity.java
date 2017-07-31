package com.yanzi.resume.activity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yanzi.resume.R;
import com.yanzi.resume.base.BaseActivity;
import com.yanzi.resume.beans.ExperienceEntity;
import com.yanzi.resume.util.UiUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建者     黄燕
 * 创建时间   2017/7/23 19:35
 * 描述	      ${工作经历界面}
 *
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class ExperienceActivity extends BaseActivity{
    private TextView navigation_title;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void initData() {
        //        ButterKnife.bind(this);
        navigation_title.setText("工作经历");

        //创建现行LinearLayoutManager
        mLayoutManager = new LinearLayoutManager(this);
        //设置LayoutMananger
        mRecyclerView.setLayoutManager(mLayoutManager);
        //设置item的动画，可以不设置
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置Adapter
        mRecyclerView.setAdapter(new MyAdapter(initDatas()));
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        navigation_title = (TextView) findViewById(R.id.navigation_title);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_experience;
    }

    @Override
    protected void processClick(View v) {

    }

    private List<ExperienceEntity> initDatas(){
        List<ExperienceEntity> list = new ArrayList<>();
        String time1 = UiUtil.getSring(R.string.time1,"");;
        String name1 = "深圳市小辣椒虚拟现实有限公司";
        String responsibility1 = UiUtil.getSring(R.string.responsibility1,"");
        ExperienceEntity entity1 = new ExperienceEntity(time1,name1,responsibility1);
        list.add(entity1);

        String time2 = UiUtil.getSring(R.string.time2,"");;
        String name2 = "深圳市AA科技有限公司";
        String responsibility2 = UiUtil.getSring(R.string.responsibility2,"");
        ExperienceEntity entity2 = new ExperienceEntity(time2,name2,responsibility2);
        list.add(entity2);

        String time3 = UiUtil.getSring(R.string.time3,"");;
        String name3= "佛山市BB科技有限公司";
        String responsibility3 = UiUtil.getSring(R.string.responsibility3,"");
        ExperienceEntity entity3 = new ExperienceEntity(time3,name3,responsibility3);
        list.add(entity3);
        return list;
    }

    class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        private List<ExperienceEntity> items;

        public MyAdapter(List<ExperienceEntity> items) {
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.experience_recycleview_item, parent, false);
            return new ViewHolder(view);
        }

        /**
         * 通过ViewHolder将数据绑定到界面上进行显示
         * @param holder
         * @param position
         */
        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            holder.time.setText(items.get(position).getTime());
            holder.company_name.setText(items.get(position).getCompany_name());
            holder.responsibility.setText(items.get(position).getResponsibility());
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView time;
            public TextView company_name;
            public TextView responsibility;

            public ViewHolder(View itemView) {
                super(itemView);
                time = (TextView) itemView.findViewById(R.id.time);
                company_name = (TextView) itemView.findViewById(R.id.company_name);
                responsibility = (TextView) itemView.findViewById(R.id.responsibility);
            }
        }
    }
}
