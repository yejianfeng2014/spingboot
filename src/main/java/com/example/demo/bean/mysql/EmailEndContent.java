package com.example.demo.bean.mysql;

public class EmailEndContent {
    private String id;

    private String content;

    private String beizhuCn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getBeizhuCn() {
        return beizhuCn;
    }

    public void setBeizhuCn(String beizhuCn) {
        this.beizhuCn = beizhuCn == null ? null : beizhuCn.trim();
    }
}