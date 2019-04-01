package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailMidContent;

public interface EmailMidContentMapper {
    int insert(EmailMidContent record);

    int insertSelective(EmailMidContent record);
}