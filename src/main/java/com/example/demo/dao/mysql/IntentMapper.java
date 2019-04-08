package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.IntentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IntentMapper {
    int insert(IntentEntity record);

    long total();

    List<IntentEntity> queryPageBySql(Map<String, Object> data);

    int update(IntentEntity user);

    int deleteById(String id);




}