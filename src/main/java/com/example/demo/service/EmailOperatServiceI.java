package com.example.demo.service;

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

public interface EmailOperatServiceI {

    /**
     * 意图标注
     * @param text
     * @return
     */
    public Temail getOneEmail(String text);


    /**
     * save 标记结果
     */


     public  void  updataEmail(Temail temail);


    /**
     * 增加一个一个数据
     */


    public  void insert(Temail temail);


    /**
     * 删除一个数据
     */

    public  void delete(String id);


    /**
     * 获取所有的email
     * @return
     */
    public List<Temail> getALL();


    Temail getOne2Biaoji();



}
