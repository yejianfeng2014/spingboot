package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailSellResponseMid;
import com.example.demo.bean.mysql.EmailSellResponseOthers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmailSellResponseOthersMapper {
    int insert(EmailSellResponseOthers record);

    int insertSelective(EmailSellResponseOthers record);

    long total();

    List<EmailSellResponseOthers> queryPageBySql(Map<String,Object> data);

    int update(EmailSellResponseOthers user);

    int deleteById(String id);


}