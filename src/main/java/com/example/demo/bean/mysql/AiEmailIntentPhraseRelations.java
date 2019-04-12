package com.example.demo.bean.mysql;

import java.util.Date;

public class AiEmailIntentPhraseRelations {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer intentId;

    private String templateId;

    private String intentIdDetail;

    private String templateIdDetail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getIntentId() {
        return intentId;
    }

    public void setIntentId(Integer intentId) {
        this.intentId = intentId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public String getIntentIdDetail() {
        return intentIdDetail;
    }

    public void setIntentIdDetail(String intentIdDetail) {
        this.intentIdDetail = intentIdDetail == null ? null : intentIdDetail.trim();
    }

    public String getTemplateIdDetail() {
        return templateIdDetail;
    }

    public void setTemplateIdDetail(String templateIdDetail) {
        this.templateIdDetail = templateIdDetail == null ? null : templateIdDetail.trim();
    }
}