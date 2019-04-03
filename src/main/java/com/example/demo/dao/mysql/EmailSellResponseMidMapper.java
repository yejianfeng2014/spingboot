package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailSellResponseMid;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmailSellResponseMidMapper {
    int insert(EmailSellResponseMid record);

    int insertSelective(EmailSellResponseMid record);


    long total();

    List<EmailSellResponseMid> queryPageBySql(Map<String,Object> data);

    int update(EmailSellResponseMid user);

    int deleteById(String id);


}