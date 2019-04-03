package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailSellResponseEnd;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmailSellResponseEndMapper {
    int insert(EmailSellResponseEnd record);
    long total();
    List<EmailSellResponseEnd> queryPageBySql(Map<String,Object> data);

    int update(EmailSellResponseEnd user);

    int deleteById(String id);

}