package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailSellResponseEnd;

public interface EmailSellResponseEndMapper {
    int insert(EmailSellResponseEnd record);

    int insertSelective(EmailSellResponseEnd record);
}