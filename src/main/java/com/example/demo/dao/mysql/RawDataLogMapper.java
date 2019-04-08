package com.example.demo.dao.mysql;


import com.example.demo.bean.mysql.RawDataLogEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface RawDataLogMapper {
    int deleteByPrimaryKey(Long id);


    int insertSelective(RawDataLogEntity record);

    RawDataLogEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RawDataLogEntity record);

    int updateByPrimaryKeyWithBLOBs(RawDataLogEntity record);


//    int insert(IntentTemplateRelationsEntity record);

    //    int insertSelective(IntentTemplateRelationsEntity record);
    int insert(RawDataLogEntity record);

    long total();

    List<RawDataLogEntity> queryPageBySql(Map<String, Object> data);

    int update(RawDataLogEntity user);


    int deleteById(long id);


}