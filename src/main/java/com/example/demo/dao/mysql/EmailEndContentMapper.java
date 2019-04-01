package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailEndContent;

public interface EmailEndContentMapper {
    int insert(EmailEndContent record);

    int insertSelective(EmailEndContent record);
}