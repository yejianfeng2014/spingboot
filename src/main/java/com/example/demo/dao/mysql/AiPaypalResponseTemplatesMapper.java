package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.AiPaypalResponseTemplatesEntity;
import com.example.demo.bean.mysql.EmailSellResponseBeggin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AiPaypalResponseTemplatesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AiPaypalResponseTemplatesEntity record);

    int insertSelective(AiPaypalResponseTemplatesEntity record);

    AiPaypalResponseTemplatesEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AiPaypalResponseTemplatesEntity record);

    int updateByPrimaryKeyWithBLOBs(AiPaypalResponseTemplatesEntity record);

    int updateByPrimaryKey(AiPaypalResponseTemplatesEntity record);




//    int insert(AiPaypalResponseTemplatesEntity record);

    int insertSelective(EmailSellResponseBeggin record);



    long total();

    List<AiPaypalResponseTemplatesEntity> queryPageBySql(Map<String,Object> data);

    int update(AiPaypalResponseTemplatesEntity user);

    int deleteById(Integer id);

//    List<AiPaypalResponseTemplatesEntity> getALL();


    /**
     * 根据意图短语返回意图，返回意图短语，意图关系，回复模板
     *
     *
     */

  List <AiPaypalResponseTemplatesEntity>  getPayPalTemplates(String text);



}