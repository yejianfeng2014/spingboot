package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailSellResponseMid;

public interface EmailSellResponseMidMapper {
    int insert(EmailSellResponseMid record);

    int insertSelective(EmailSellResponseMid record);
}