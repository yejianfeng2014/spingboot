package com.example.demo.bean.mysql;

public class EmailSellResponseOthers {
    private String id;

    private String contentType;

    private String contentCn;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}