package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailBegginContent;

public interface EmailBegginContentMapper {
    int insert(EmailBegginContent record);

    int insertSelective(EmailBegginContent record);
}