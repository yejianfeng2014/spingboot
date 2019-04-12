package com.example.demo.bean.mysql;

public class AiEmailIntentPhrase {
    private Integer id;

    private Integer intentId;

    private String intentPhrase;

    private String intentDetail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIntentId() {
        return intentId;
    }

    public void setIntentId(Integer intentId) {
        this.intentId = intentId;
    }

    public String getIntentPhrase() {
        return intentPhrase;
    }

    public void setIntentPhrase(String intentPhrase) {
        this.intentPhrase = intentPhrase == null ? null : intentPhrase.trim();
    }

    public String getIntentDetail() {
        return intentDetail;
    }

    public void setIntentDetail(String intentDetail) {
        this.intentDetail = intentDetail == null ? null : intentDetail.trim();
    }
}