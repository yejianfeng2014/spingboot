package com.example.demo.dao.mysql;


import com.example.demo.bean.mysql.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserDao {
    User selectById(String id);

    List<User> selectAll();

    User selectByUserName(String username);

    void insert(User user);

    int update(User user);

    int deleteById(String id);
}
