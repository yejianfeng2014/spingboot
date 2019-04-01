package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailSellResponseBeggin;

public interface EmailSellResponseBegginMapper {
    int insert(EmailSellResponseBeggin record);

    int insertSelective(EmailSellResponseBeggin record);
}