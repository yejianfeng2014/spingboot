package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.IntentPhraseEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IntentPhraseMapper {
    int insert(IntentPhraseEntity record);

//    int insertSelective(IntentPhraseEntity record);

    long total();

    List<IntentPhraseEntity> queryPageBySql(Map<String, Object> data);

    int update(IntentPhraseEntity user);

    int deleteById(int id);

//    List<EmailSellResponseBeggin> getALL();



    List<IntentPhraseEntity> queryByPhrase(String text);


    List<IntentPhraseEntity> queryByPhraseId(int phraseId);



}