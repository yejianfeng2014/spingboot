package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.AiEmailIntentPhraseRelations;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface AiEmailIntentPhraseRelationsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AiEmailIntentPhraseRelations record);

    int insertSelective(AiEmailIntentPhraseRelations record);

    AiEmailIntentPhraseRelations selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AiEmailIntentPhraseRelations record);

    int updateByPrimaryKey(AiEmailIntentPhraseRelations record);



    long total();

    List<AiEmailIntentPhraseRelations> queryPageBySql(Map<String,Object> data);

//    int update(AiEmailIntentPhraseRelations user);

//    int deleteById(String id);

//    List<AiEmailIntentPhraseRelations> getALL();

}