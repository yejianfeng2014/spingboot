package com.example.demo.service;

import com.example.demo.bean.mysql.Temail;
import com.example.demo.dao.mysql.TemailMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;



@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailOperatServiceITest {



    @Resource
    TemailMapper temailMapper;
    @Test
    public void getUser() {
        Temail temail = temailMapper.selectByPrimaryKey(895);

        System.out.println(temail.getId());


    }




}