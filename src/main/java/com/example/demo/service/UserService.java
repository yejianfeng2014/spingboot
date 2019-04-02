package com.example.demo.service;

import com.example.demo.bean.mysql.User;

import java.util.List;

public interface UserService {
    User selectById(String id);
    User selectByUserName(String username);

    List<User> selectAll();

    String insert(User user);

    boolean update(User user);

    boolean delete(String id);
}
