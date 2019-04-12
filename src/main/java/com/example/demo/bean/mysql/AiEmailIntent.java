package com.example.demo.bean.mysql;

import java.util.Date;

public class AiEmailIntent {
    private Integer id;

    private String intentName;

    private String intentDetail;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName == null ? null : intentName.trim();
    }

    public String getIntentDetail() {
        return intentDetail;
    }

    public void setIntentDetail(String intentDetail) {
        this.intentDetail = intentDetail == null ? null : intentDetail.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}