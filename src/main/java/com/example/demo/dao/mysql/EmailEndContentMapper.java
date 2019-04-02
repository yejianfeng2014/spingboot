package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailEndContent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailEndContentMapper {
    int insert(EmailEndContent record);

    int insertSelective(EmailEndContent record);
}