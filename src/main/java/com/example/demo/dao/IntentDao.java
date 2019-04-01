package com.example.demo.dao;

import com.example.demo.entry.Email;
import com.example.demo.entry.User;

public interface IntentDao {



    // 根据id 查询用户信息
//    public Email getUser(String id);



    public  Email toBiaoji();

    // 根据id 修改标记


    public  void  updateEmail(Email email);



}
