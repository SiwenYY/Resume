package com.yanzi.resume.beans;

/**
 * 创建者     黄燕
 * 创建时间   2017/7/23 20:39
 * 描述	      ${TODO}
 *
 * 更新者     $Author$
 * 更新时间   $Date$
 * 更新描述   ${TODO}
 */
public class ExperienceEntity {
    private String time;
    private String company_name;
    private String responsibility;

    public ExperienceEntity(String time, String company_name, String responsibility) {
        this.time = time;
        this.company_name = company_name;
        this.responsibility = responsibility;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }



}
