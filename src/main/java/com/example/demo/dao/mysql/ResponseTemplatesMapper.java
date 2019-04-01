package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.ResponseTemplates;

public interface ResponseTemplatesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ResponseTemplates record);

    int insertSelective(ResponseTemplates record);

    ResponseTemplates selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ResponseTemplates record);

    int updateByPrimaryKey(ResponseTemplates record);
}