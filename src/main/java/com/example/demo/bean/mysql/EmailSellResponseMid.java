package com.example.demo.bean.mysql;

public class EmailSellResponseMid {
    private String id;

    private String contenType;

    private String contentCn;

    private String contentResponse;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getContenType() {
        return contenType;
    }

    public void setContenType(String contenType) {
        this.contenType = contenType == null ? null : contenType.trim();
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