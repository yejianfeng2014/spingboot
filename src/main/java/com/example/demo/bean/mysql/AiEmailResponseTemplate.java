package com.example.demo.bean.mysql;

import java.util.Date;

public class AiEmailResponseTemplate {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String templateId;

    private String responseParams;

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

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId == null ? null : templateId.trim();
    }

    public String getResponseParams() {
        return responseParams;
    }

    public void setResponseParams(String responseParams) {
        this.responseParams = responseParams == null ? null : responseParams.trim();
    }

    private String responseTime;

    private String contentType;

    private String contentCn;

    private String contentResponse;

    private String contentResponseCn;

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime == null ? null : responseTime.trim();
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType == null ? null : contentType.trim();
    }

    public String getContentCn() {
        return contentCn;
    }

    public void setContentCn(String contentCn) {
        this.contentCn = contentCn == null ? null : contentCn.trim();
    }

    public String getContentResponse() {
        return contentResponse;
    }

    public void setContentResponse(String contentResponse) {
        this.contentResponse = contentResponse == null ? null : contentResponse.trim();
    }

    public String getContentResponseCn() {
        return contentResponseCn;
    }

    public void setContentResponseCn(String contentResponseCn) {
        this.contentResponseCn = contentResponseCn == null ? null : contentResponseCn.trim();
    }



}