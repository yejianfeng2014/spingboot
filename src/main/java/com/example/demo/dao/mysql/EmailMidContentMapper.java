package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailMidContent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailMidContentMapper {
    int insert(EmailMidContent record);

    int insertSelective(EmailMidContent record);
}