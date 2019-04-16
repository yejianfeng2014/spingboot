package com.example.demo.service;

import com.example.demo.bean.mysql.AiPaypalResponseTemplatesEntity;
import com.example.demo.bean.mysql.IntentTemplateRelationsEntity;

import java.util.List;

public interface GetModelTemplateServiceI {

    /**
     * 获取模板的关系
     */
    public List <IntentTemplateRelationsEntity> getTemplateId(String text);


    /**
     * 查询PayPal的模板
     * @param text
     * @return
     */
    public List <AiPaypalResponseTemplatesEntity> getTemplateIds_paypal(String text);

    /**
     * 查询邮件的模板
     * @param text
     * @return
     */
//    public List <AiPaypalResponseTemplatesEntity> getTemplateIds_paypal(String text);


    /**
     * 查询PayPal的模板
     * @param text
     *
     * @return
     */
    public List <AiPaypalResponseTemplatesEntity> getTemplateIdsPaypalOderStatusConditon(String text,int order_status,int other_condition);



}
