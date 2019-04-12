package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.AiEmailIntentPhrase;
import com.example.demo.bean.mysql.EmailSellResponseBeggin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface AiEmailIntentPhraseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AiEmailIntentPhrase record);

    int insertSelective(AiEmailIntentPhrase record);

    AiEmailIntentPhrase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AiEmailIntentPhrase record);

    int updateByPrimaryKey(AiEmailIntentPhrase record);



    long total();

    List<AiEmailIntentPhrase> queryPageBySql(Map<String,Object> data);

//    int update(AiEmailIntentPhrase user);

//    int deleteById(String id);

//    List<AiEmailIntentPhrase> getALL();

}