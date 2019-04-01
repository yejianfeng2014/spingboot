package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailSellResponseOthers;

public interface EmailSellResponseOthersMapper {
    int insert(EmailSellResponseOthers record);

    int insertSelective(EmailSellResponseOthers record);
}