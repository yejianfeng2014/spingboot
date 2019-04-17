package com.example.demo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ErpQueyServiceITest {


    @Resource
    ErpQueyServiceI serviceI;
    @Test
    public void getUser() {


        String tex = serviceI.queryInfoByTx("tex");


        System.out.println(tex);


        JSONObject jsonObject = JSONObject.parseObject(tex);


        JSONObject response = jsonObject.getJSONObject("response");

        String totalCount = response.getString("TotalCount");


        System.out.println(totalCount);


        JSONArray list = response.getJSONArray("list");

        // totalCount= 1 说明是一个包裹 ,处理一个订单

        JSONObject jsonObject1 = list.getJSONObject(0); // 改成多个

        String orderNo = jsonObject1.getString("OrderNo");

        String orderGoodsCount = jsonObject1.getString("OrderGoodsCount");

        String siteId =jsonObject1.getString("SiteId");
        String siteName =jsonObject1.getString("SiteName");

        String orderStatusName =jsonObject1.getString("OrderStatusName");

    }



    @Test
    public  void queryByOrderNoAndSiteID_1(){


    }





        @Test
    public  void queryByOrderNoAndSiteID(){

/*
        String s = serviceI.queryByOrderNoAndSiteID("a", "b");

        JSONObject jsonObject = JSONObject.parseObject(s);

        String createTime = jsonObject.getString("CreateTime");

        System.out.println(createTime);


        JSONArray response = jsonObject.getJSONArray("response");

        JSONObject jsonObject1 = response.getJSONObject(0);
        JSONObject packageList = jsonObject1.getJSONArray("PackageList").getJSONObject(0);


        // 快递单号
        String expressNo = packageList.getString("ExpressNo");


        JSONArray packageStatusList = packageList.getJSONArray("PackageStatusList");


        String retDate = "";

       for (int i =0 ;i< packageStatusList.size();i++){

           JSONObject jsonObject2 = packageStatusList.getJSONObject(i);
           Integer status = jsonObject2.getInteger("Status");

           if (status == 3){
              retDate = jsonObject2.getString("CreateTime");
           }
       }*/



        Calendar c = Calendar.getInstance();
        Date date = c.getTime();

        System.out.println(date);
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        String string = "2019-04-22T16:18:10";

        Date parse = null;

        try {
             parse = simple.parse(string);

            System.out.println(parse);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        int a = (int) (( parse.getTime()- date.getTime()) / (1000*3600*24));


        System.out.println(a);





//        Date parse = simple.parse(string);

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
//
//
////        formatter.parse
//        Date date1 = new Date(System.currentTimeMillis());
//
//
//
//
//
//        LocalDate date = LocalDate.parse(string, formatter);
//


//        System.out.println(date);
//
//
//        System.out.println(date1);


//        System.out.println(retDate);


    }



    @Test
    public  void  expressInfo(){


        String s1 = serviceI.queryTrackerNO("");



        JSONObject jsonObject2 = JSONObject.parseObject(s1);

        // 快递类型
        String carrier_code = jsonObject2.getString("carrier_code");


        JSONObject origin_info = jsonObject2.getJSONObject("origin_info");


        JSONArray trackinfo = origin_info.getJSONArray("trackinfo");

        // 寻找最后一次更新时间

        String lastDate = "";

        for (int i = 0; i < trackinfo.size(); i++) {

            JSONObject jsonObject3 = trackinfo.getJSONObject(i);

            String date = jsonObject3.getString("Date");

            if (date.compareTo(lastDate)  >0){
                lastDate = date;
            }
        }

        System.out.println(lastDate);

    }




}