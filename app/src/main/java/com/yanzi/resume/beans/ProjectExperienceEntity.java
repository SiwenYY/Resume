package com.yanzi.resume.beans;

/**
 * 创建者     黄燕
 * 创建时间   2017/7/23 20:39
 * 描述	      ${项目经验实例}
 *
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class ProjectExperienceEntity {
    private String project_title;
    private String project_description_content;
    private String project_technology_overview;
    private String project_name;

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_title() {
        return project_title;
    }

    public void setProject_title(String project_title) {
        this.project_title = project_title;
    }

    public String getProject_description_content() {
        return project_description_content;
    }

    public void setProject_description_content(String project_description_content) {
        this.project_description_content = project_description_content;
    }

    public String getProject_technology_overview() {
        return project_technology_overview;
    }

    public void setProject_technology_overview(String project_technology_overview) {
        this.project_technology_overview = project_technology_overview;
    }

    public ProjectExperienceEntity(String project_title, String project_name, String project_description_content, String project_technology_overview) {
        this.project_title = project_title;
        this.project_name = project_name;
        this.project_description_content = project_description_content;
        this.project_technology_overview = project_technology_overview;
    }


}
