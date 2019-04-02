package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailSellResponseBeggin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailSellResponseBegginMapper {
    int insert(EmailSellResponseBeggin record);

    int insertSelective(EmailSellResponseBeggin record);
}