package com.example.demo.service;


import com.example.demo.bean.mysql.RawDataLogEntity;

import java.io.Serializable;
import java.util.List;

public interface RawDataLogServiceI {


    public Serializable save(RawDataLogEntity entity) throws Exception;

    public void Update(RawDataLogEntity entity) throws Exception;


    public void delete(RawDataLogEntity entity) throws Exception;

    public void delete(Integer id) throws Exception;


    public long totalSum();

    List<RawDataLogEntity> queryStudentsBySql(int currPage, int pageSize);


}
