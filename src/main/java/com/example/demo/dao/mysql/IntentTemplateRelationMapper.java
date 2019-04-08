package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.IntentTemplateRelationsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IntentTemplateRelationMapper {
    int insert(IntentTemplateRelationsEntity record);

//    int insertSelective(IntentTemplateRelationsEntity record);

    long total();

    List<IntentTemplateRelationsEntity> queryPageBySql(Map<String, Object> data);

    int update(IntentTemplateRelationsEntity user);

    int deleteById(int id);



}