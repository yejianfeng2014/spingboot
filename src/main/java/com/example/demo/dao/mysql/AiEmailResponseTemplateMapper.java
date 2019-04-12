package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.AiEmailResponseTemplate;
import com.example.demo.bean.mysql.EmailSellResponseBeggin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface AiEmailResponseTemplateMapper {
    int insert(AiEmailResponseTemplate record);

    int insertSelective(AiEmailResponseTemplate record);

    long total();

    List<EmailSellResponseBeggin> queryPageBySql(Map<String,Object> data);


   void deleteById(Integer id) ;

   void updateByPrimaryKey(AiEmailResponseTemplate record);



}