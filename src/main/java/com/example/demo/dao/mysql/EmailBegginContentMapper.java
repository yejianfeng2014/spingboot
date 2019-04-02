package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailBegginContent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailBegginContentMapper {
    int insert(EmailBegginContent record);

    int insertSelective(EmailBegginContent record);
}