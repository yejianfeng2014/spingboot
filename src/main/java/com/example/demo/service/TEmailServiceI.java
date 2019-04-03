package com.example.demo.service;

import com.example.demo.bean.mysql.EmailSellResponseBeggin;
import com.example.demo.bean.mysql.Temail;

import java.util.List;

/**
 * Created by yejianfeng on 2018/11/14.
 *
 *
 * 标注过程
 * 标注数据的增，删，改，查
 *
 */

public interface TEmailServiceI {

    Temail getOne2Biaoji();



    public void delete(Temail entity) throws Exception;

    public int save(Temail entity) throws Exception;

    public void saveOrUpdate(Temail entity) throws Exception;


    public long totalSum();

    List<Temail> queryPageBySql(int currPage, int pageSize);


    List<Temail> queryStudentsAll();





}
