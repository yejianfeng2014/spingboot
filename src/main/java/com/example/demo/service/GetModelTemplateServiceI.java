package com.example.demo.service;

import com.example.demo.bean.mysql.IntentTemplateRelationsEntity;

import java.util.List;

public interface GetModelTemplateServiceI {

    /**
     * 获取模板的id
     */
    public List <IntentTemplateRelationsEntity> getTemplateId(String text);



}
