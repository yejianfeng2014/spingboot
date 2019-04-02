package com.example.demo.dao.mysql;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResponseTemplatesMapper {
    int deleteByPrimaryKey(Integer id);

}