package com.example.demo.bean.mysql;

public class EmailSellResponseEnd {
    private String id;

    private String contentType;

    private String contentCn;

    private String contentResponse;

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

    public String getContentResponse() {
        return contentResponse;
    }

    public void setContentResponse(String contentResponse) {
        this.contentResponse = contentResponse == null ? null : contentResponse.trim();
    }
}