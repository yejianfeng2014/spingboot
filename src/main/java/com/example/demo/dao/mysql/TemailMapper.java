package com.example.demo.dao.mysql;

import com.example.demo.bean.mysql.EmailSellResponseBeggin;
import com.example.demo.bean.mysql.Temail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TemailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Temail record);

    int insertSelective(Temail record);

    Temail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Temail record);

    int updateByPrimaryKeyWithBLOBs(Temail record);

    int updateByPrimaryKey(Temail record);


    List<Temail>  selectAll();

    Temail selectOnetoBiaoji();


    long total();

    List<Temail> queryPageBySql(Map<String,Object> data);




}