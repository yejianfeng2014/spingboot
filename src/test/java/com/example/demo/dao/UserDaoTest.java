package com.example.demo.dao;

import com.example.demo.entry.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest
{

    @Resource UserDao userDao;
    @Test
    public void getUser() {
        User user = userDao.getUser("123");
        System.out.println(user.getId());
        System.out.println(user.getName());

    }



}