package com.example.demo.serviceImpl;

import com.example.demo.bean.mysql.IntentTemplateRelationsEntity;
import com.example.demo.dao.mysql.IntentTemplateRelationMapper;
import com.example.demo.service.GetModelTemplateServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetModelTemplateServiceImpl implements GetModelTemplateServiceI {


    @Autowired
    IntentTemplateRelationMapper intentTemplateRelationMapper;

    @Override
    public List<IntentTemplateRelationsEntity> getTemplateId(String text) {

        List<IntentTemplateRelationsEntity> hi = intentTemplateRelationMapper.queryByintentPhrase(text);

        return hi;

    }
}
