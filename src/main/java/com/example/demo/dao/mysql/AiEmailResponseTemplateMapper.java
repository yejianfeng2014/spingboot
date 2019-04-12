package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.AiEmailResponseTemplateWithBLOBs;
import com.example.demo.bean.mysql.EmailSellResponseBeggin;

import java.util.List;
import java.util.Map;

public interface AiEmailResponseTemplateMapper {
    int insert(AiEmailResponseTemplateWithBLOBs record);

    int insertSelective(AiEmailResponseTemplateWithBLOBs record);




    long total();

    List<EmailSellResponseBeggin> queryPageBySql(Map<String,Object> data);

    int update(EmailSellResponseBeggin user);

    int deleteById(String id);

    List<EmailSellResponseBeggin> getALL();


}