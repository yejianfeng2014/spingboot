package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailSellResponseEnd;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailSellResponseEndMapper {
    int insert(EmailSellResponseEnd record);

    int insertSelective(EmailSellResponseEnd record);
}