package com.example.demo.bean.mysql;

public class Temail {
    private Integer id;

    private String title;

    private String beizhu;

    private String biaoji;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }

    public String getBiaoji() {
        return biaoji;
    }

    public void setBiaoji(String biaoji) {
        this.biaoji = biaoji == null ? null : biaoji.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}