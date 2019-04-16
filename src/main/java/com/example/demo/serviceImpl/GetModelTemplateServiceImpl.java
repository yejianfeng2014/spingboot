package com.example.demo.serviceImpl;

import com.example.demo.bean.mysql.AiPaypalResponseTemplatesEntity;
import com.example.demo.bean.mysql.IntentTemplateRelationsEntity;
import com.example.demo.dao.mysql.AiPaypalResponseTemplatesMapper;
import com.example.demo.dao.mysql.IntentTemplateRelationMapper;
import com.example.demo.service.GetModelTemplateServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetModelTemplateServiceImpl implements GetModelTemplateServiceI {


    @Autowired
    IntentTemplateRelationMapper intentTemplateRelationMapper;



    @Autowired
    AiPaypalResponseTemplatesMapper mapper;

    @Override
    public List<IntentTemplateRelationsEntity> getTemplateId(String text) {

        List<IntentTemplateRelationsEntity> hi = intentTemplateRelationMapper.queryByintentPhrase(text);

        return hi;

    }



    @Override
    public List<AiPaypalResponseTemplatesEntity> getTemplateIds_paypal(String text) {

        List<AiPaypalResponseTemplatesEntity> payPalTemplates = mapper.getPayPalTemplates(text);


        return payPalTemplates;
    }

    @Override
    public List<AiPaypalResponseTemplatesEntity> getTemplateIdsPaypalOderStatusConditon(String text, int order_status, int other_condition) {


        Map<String,Object>  mydata = new HashMap<String,Object>();

        mydata.put("order_status", order_status);
        mydata.put("other_condition", other_condition);
        mydata.put("text", text);

        System.out.printf("order_stauts",order_status);
        System.out.printf("other_condition",order_status);
        System.out.printf("text",text);

        List<AiPaypalResponseTemplatesEntity> payPalTemplatesStatusCondition = mapper.getPayPalTemplatesStatusCondition(mydata);

        return payPalTemplatesStatusCondition;
    }
}
