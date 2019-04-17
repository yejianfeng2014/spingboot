package com.example.demo.serviceImpl;

import com.example.demo.service.ErpQueyServiceI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ErpQueryServiceImplTest {

    @Resource
    ErpQueyServiceI serviceI;


    @Test
    public void queryInfoByTx() {

        String s = serviceI.queryInfoByTx("80246787HH806324X");

        System.out.println(s);
    }

    @Test
    public void queryByOrderNoAndSiteID() {

        String sv39259 = serviceI.queryByOrderNoAndSiteID("SV39259", "178");

        System.out.println(sv39259);

    }

    @Test
    public void queryByExpressNO() {
    }

    @Test
    public void createTrackerNO() {
    }

    @Test
    public void queryTrackerNO() {
    }
}