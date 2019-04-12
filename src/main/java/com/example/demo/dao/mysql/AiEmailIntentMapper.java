package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.AiEmailIntent;

import java.util.List;
import java.util.Map;

public interface AiEmailIntentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AiEmailIntent record);

    int insertSelective(AiEmailIntent record);

    AiEmailIntent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AiEmailIntent record);

    int updateByPrimaryKey(AiEmailIntent record);

    long total();

    List<AiEmailIntent> queryPageBySql(Map<String,Object> data);

    int update(AiEmailIntent user);

    int deleteById(String id);

    List<AiEmailIntent> getALL();




}