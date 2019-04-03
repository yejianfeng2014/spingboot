package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailSellResponseBeggin;
import com.example.demo.bean.mysql.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmailSellResponseBegginMapper {
    int insert(EmailSellResponseBeggin record);

    int insertSelective(EmailSellResponseBeggin record);

    long total();

    List<EmailSellResponseBeggin> queryPageBySql(Map<String,Object> data);

    int update(EmailSellResponseBeggin user);

    int deleteById(String id);

    List<EmailSellResponseBeggin> getALL();



}