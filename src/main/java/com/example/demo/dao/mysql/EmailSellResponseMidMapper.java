package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailSellResponseMid;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailSellResponseMidMapper {
    int insert(EmailSellResponseMid record);

    int insertSelective(EmailSellResponseMid record);
}