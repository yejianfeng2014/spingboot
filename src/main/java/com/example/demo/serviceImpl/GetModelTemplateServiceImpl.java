package com.example.demo.serviceImpl;

import com.example.demo.bean.mysql.AiPaypalResponseTemplatesEntity;
import com.example.demo.bean.mysql.IntentTemplateRelationsEntity;
import com.example.demo.dao.mysql.AiPaypalResponseTemplatesMapper;
import com.example.demo.dao.mysql.IntentTemplateRelationMapper;
import com.example.demo.service.GetModelTemplateServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
