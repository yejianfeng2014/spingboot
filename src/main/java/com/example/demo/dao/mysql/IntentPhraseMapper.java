package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailSellResponseBeggin;
import com.example.demo.bean.mysql.IntentPhraseEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IntentPhraseMapper {
    int insert(IntentPhraseEntity record);

//    int insertSelective(IntentPhraseEntity record);

    long total();

    List<EmailSellResponseBeggin> queryPageBySql(Map<String, Object> data);

    int update(IntentPhraseEntity user);

    int deleteById(String id);

//    List<EmailSellResponseBeggin> getALL();



}