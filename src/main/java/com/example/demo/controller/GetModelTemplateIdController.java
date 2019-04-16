package com.example.demo.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.mysql.AiPaypalResponseTemplatesEntity;
import com.example.demo.bean.mysql.RawDataLogEntity;
import com.example.demo.model.json.AjaxJson;
import com.example.demo.service.ErpQueyServiceI;
import com.example.demo.service.GetModelTemplateServiceI;
import com.example.demo.service.IntentPhraseServiceI;
import com.example.demo.service.RawDataLogServiceI;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 获取模板id 方法
 */


@RestController("/getTemplateIdController")
@Api(tags = "getTemplateIdController", description = "获取模板id")
public class GetModelTemplateIdController {

    private static final Logger logger = LoggerFactory.getLogger(GetModelTemplateIdController.class);


    @Autowired
    private RawDataLogServiceI rawDataLogService;

    @Autowired
    GetModelTemplateServiceI getModelTemplateServiceI;


    @Autowired
    ErpQueyServiceI erpQueyServiceI;


    @Autowired
    IntentPhraseServiceI intentPhraseService;


    @RequestMapping(value = "init", method = RequestMethod.GET)
    public String templateInit() {
        // todo 模板初始化的方法，后期考虑加入Redis加快速度
        return "hello entity init";
    }

    /**
     * 获取模板id
     * params  查询语句
     * 数据来源
     * 交易号
     *
     * @return 邮件或者
     */
    @RequestMapping(value = "/getTemplateId", method = RequestMethod.POST)
    @ResponseBody
    public Object getID(String msg, String channel, String tx) {

        // TODO: 2019/4/1  从数据库读取数据

        String retmsg = "get template success";
        Map<String, Object> result_map = new HashMap<>();
        result_map.put("success", true);

        Map<String, String> keyMaps = new HashMap<>();
//        String message = null;
//        AjaxJson j = null;
        String text = null;
        String textFrom = null;


        try {
//            message = null;
//            j = new AjaxJson();
            retmsg = "获取模板id成功！！！";
            text = msg.toLowerCase().trim();
            textFrom = channel.toLowerCase().trim();
            boolean support_data_from = true;

            // 先把内容插入数据库
            saveData2log(text, textFrom);
            // 数据来源验证，
            if (support_data_from && "email".equals(textFrom.trim())) {
                support_data_from = false;
            }

            if (support_data_from && "paypal".equals(textFrom.trim())) {
                support_data_from = false;
            }

            if (support_data_from) {
                retmsg = "不支持的数据源，输入的数据源未paypal 或者email";

                result_map.put("msg", retmsg);
                logger.info("getTemplateId");

                return result_map;
            }

            // 数据内容验证,内容是否在意图中
            int i = intentPhraseService.queryByPhrase2Int(text);
            if (i < 1) {
                result_map.put("success", false);
//                j.setSuccess(false);
                logger.info("getTemplateId");
                result_map.put("msg", retmsg);
                return result_map;

            }

            // 处理正常的业务

            String s = erpQueyServiceI.queryInfoByTx(tx);// 返回结果1

            if ("".equals(s)) {
                retmsg = "查询erp 失败";
                result_map.put("msg", retmsg);
                return result_map;
            }

            JSONObject jsonObject = JSONObject.parseObject(s);
            JSONObject response = jsonObject.getJSONObject("response");
            String totalCount = response.getString("TotalCount");
            int int_totalCount = Integer.parseInt(totalCount);
            if (int_totalCount == 1) {
                JSONArray list = response.getJSONArray("list");
                JSONObject jsonObject1 = list.getJSONObject(0); // 改成多个
                String orderNo = jsonObject1.getString("OrderNo");
                String orderGoodsCount = jsonObject1.getString("OrderGoodsCount");
                String siteId = jsonObject1.getString("SiteId");
                String siteName = jsonObject1.getString("SiteName");
                String orderStatusName = jsonObject1.getString("OrderStatusName");
                String shippingTypeName = jsonObject1.getString("ShippingTypeName");
                String receiver = jsonObject1.getString("Receiver");
                String address = jsonObject1.getString("Address");
                String city = jsonObject1.getString("City");
                String country = jsonObject1.getString("Country");
                String state = jsonObject1.getString("State");
                String phoneNumber = jsonObject1.getString("PhoneNumber");
                String zipCode = jsonObject1.getString("ZipCode");

                keyMaps.put("sitName", siteName);
                keyMaps.put("siteId", siteId);
                keyMaps.put("order_no", orderNo);
                keyMaps.put("receiver_value", receiver);
                keyMaps.put("address_value", address);
                keyMaps.put("city_value", city);
                keyMaps.put("country_value", country);
                keyMaps.put("state_value", state);
                keyMaps.put("phonenumber_value", phoneNumber);
                keyMaps.put("zipcode_value", zipCode);


                // 1 ,判断发货状态
                if ("paypal".equals(textFrom.trim())) {

                    List<AiPaypalResponseTemplatesEntity> templateIdAll_allfahuo = getTemplateIdAll_allfahuo(text, orderNo, siteId, orderStatusName, shippingTypeName);

                    if (templateIdAll_allfahuo != null) {
                        result_map.put("list", templateIdAll_allfahuo);

                    } else {

                        In3day in3day = iCanShipIn3Days(orderNo, siteId);

                        if (in3day.isSucess) {
                            List<AiPaypalResponseTemplatesEntity> templateIdAllShiped = getTemplateIdAll(text, orderNo, siteId, orderStatusName, shippingTypeName, in3day);
                            if (templateIdAllShiped != null) {
                                result_map.put("list", templateIdAllShiped);
                            }
                        } else {
                            msg = in3day.getMsg();
                        }
                    }

                }
            }

            // todo int_totalCount !=1 的处理

        } catch (Exception e) {
            e.printStackTrace();
            retmsg = "获取模板id失败！！！";
            result_map.put("success", false);
        }
        result_map.put("msg", retmsg);
        return result_map;
    }


    public List<AiPaypalResponseTemplatesEntity> getTemplateIdAll(String text, String orderNo, String siteId, String orderStatusName, String shippingTypeName, In3day in7day) {
        List<AiPaypalResponseTemplatesEntity> templateIds_paypal = null;

        // 2,部分发货
        if ("部分发货".equals(orderStatusName)) {
            // 回复部分发货的模板

            if (in7day.isSucess) {
                boolean isLess7day = in7day.isLess7day;

                if (isLess7day) {

                    // 回复内3天的模板
                    templateIds_paypal = getModelTemplateServiceI.getTemplateIdsPaypalOderStatusConditon(text, 1, 1);
                } else {

                    // 回复3天外的模板
                    templateIds_paypal = getModelTemplateServiceI.getTemplateIdsPaypalOderStatusConditon(text, 1, 2);
                }
            }
        }

        if ("待审核".equals(orderStatusName) || "已付款".equals(orderStatusName)) {

            if (in7day.isSucess) {
                boolean isLess7day = in7day.isLess7day;

                if (isLess7day) {
                    // 回复内3天的模板
                    templateIds_paypal = getModelTemplateServiceI.getTemplateIdsPaypalOderStatusConditon(text, 1, 1);
                } else {
                    // 回复3天外的模板
                    templateIds_paypal = getModelTemplateServiceI.getTemplateIdsPaypalOderStatusConditon(text, 1, 2);
                }

            }
        }

        return templateIds_paypal;
    }


    public List<AiPaypalResponseTemplatesEntity> getTemplateIdAll_allfahuo(String text, String orderNo, String siteId, String orderStatusName, String shippingTypeName) {
        List<AiPaypalResponseTemplatesEntity> templateIds_paypal = null;


        if ("全部发货".equals(orderStatusName)) {


            int shipedStatus_int = allShipedStatus(orderNo, siteId, shippingTypeName);

            if (shipedStatus_int == 0) {

                return null;
            }


            if (shipedStatus_int == 0) {


                templateIds_paypal = getModelTemplateServiceI.getTemplateIdsPaypalOderStatusConditon(text, 3, 0);

            }
            if (shipedStatus_int == 1) {

                templateIds_paypal = getModelTemplateServiceI.getTemplateIdsPaypalOderStatusConditon(text, 3, 2);

            }

            if (shipedStatus_int == 2) {
                templateIds_paypal = getModelTemplateServiceI.getTemplateIdsPaypalOderStatusConditon(text, 3, 3);

            }
            if (shipedStatus_int == 3) {
                templateIds_paypal = getModelTemplateServiceI.getTemplateIdsPaypalOderStatusConditon(text, 3, 4);

            }
            if (shipedStatus_int == 4) {
                templateIds_paypal = getModelTemplateServiceI.getTemplateIdsPaypalOderStatusConditon(text, 3, 2);
            }

        }

        return templateIds_paypal;
    }


    public void saveData2log(String text, String textFrom) {
        try {
            logger.info("textFrom: " + textFrom);
            logger.info("text:" + text);
            RawDataLogEntity rawDataLogEntity = new RawDataLogEntity();
            rawDataLogEntity.setRawText(text);
            rawDataLogEntity.setSourceType(textFrom);
            rawDataLogService.save(rawDataLogEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private In3day iCanShipIn3Days(String orderNO, String siteID) {

        In3day j = new In3day();

//        Map<String, Boolean> stringHashMap = new HashMap<String, Boolean>();

//        String keyString = "is_in7day";


        try {
            // 使用第二个请求就可以判断是否七天发货 返回2

            String s = erpQueyServiceI.queryByOrderNoAndSiteID(orderNO, siteID);

            if ("".equals(s)) {

                j.setSucess(false);
                j.setMsg("erp 查询结构返回结果是空！！！");

                return j;

            }

            JSONObject jsonObject = JSONObject.parseObject(s);


            JSONArray response = jsonObject.getJSONArray("response");

            JSONObject jsonObject1 = response.getJSONObject(0);
            JSONObject packageList = jsonObject1.getJSONArray("PackageList").getJSONObject(0);

            // 快递单号
            String expressNo = packageList.getString("ExpressNo");


            JSONArray packageStatusList = packageList.getJSONArray("PackageStatusList");


            String retDate = "";

            for (int i = 0; i < packageStatusList.size(); i++) {

                JSONObject jsonObject2 = packageStatusList.getJSONObject(i);
                Integer status = jsonObject2.getInteger("Status");

                if (status == 3) {
                    retDate = jsonObject2.getString("CreateTime");
                }
            }


            Calendar c = Calendar.getInstance();
            Date date = c.getTime();

            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");


            Date parse = null;

            try {
                parse = simple.parse(retDate);

            } catch (ParseException e) {
                e.printStackTrace();
            }


            int a = (int) ((parse.getTime() - date.getTime()) / (1000 * 3600 * 24));

            if (a < 3) {

                j.setLess7day(true);
//                stringHashMap.put(keyString,false);


//                return true;
            } else {
                j.setLess7day(false);

//                stringHashMap.put(keyString,true);

            }
        } catch (Exception e) {
            e.printStackTrace();
            j.setSucess(false);
//            j.setSuccess(false);
        }


//        j.setAttributes(stringHashMap);

        return j;


    }


    class In3day {

        boolean isSucess = true;

        boolean isLess7day = true;

        String msg;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public boolean isSucess() {
            return isSucess;
        }

        public void setSucess(boolean sucess) {
            isSucess = sucess;
        }

        public boolean isLess7day() {
            return isLess7day;
        }

        public void setLess7day(boolean less7day) {
            isLess7day = less7day;
        }
    }

    // 返回数字 1,2,3,4  默认值是0
    private int allShipedStatus(String orderNO, String siteID, String shippingTypeName) {


        int result_int = 0;

//        1  正常在途   2，已妥投，3，长期不更新，4，未妥投退回
        // TODO: 2019/4/16  修改编号1 的bug  未妥投退回暂时没法判断。
        // 编号1 已经妥投（存在的问题，退回的单号也混在一起了。）
        // 编号2 正常在途
        // 编号3 长期不更新
        // 编号4 未妥投退回

        //1,正常在途  判断依据最近3-7天物流在更新

        try {
            // 物流更新信息
            String s = erpQueyServiceI.queryByOrderNoAndSiteID(orderNO, siteID);

            if ("".equals(s)) {
                return result_int;
            }

            JSONObject jsonObject = JSONObject.parseObject(s);


            JSONArray response = jsonObject.getJSONArray("response");

            JSONObject jsonObject1 = response.getJSONObject(0);
            JSONObject packageList = jsonObject1.getJSONArray("PackageList").getJSONObject(0);

            // 快递单号
            String expressNo = packageList.getString("ExpressNo");


            String s2 = erpQueyServiceI.queryByExpressNO(expressNo);


            JSONObject jsonObject4 = JSONObject.parseObject(s2);

            JSONArray response1 = jsonObject4.getJSONArray("response");

            JSONObject jsonObject5 = response1.getJSONObject(0);

            int traceStatus = jsonObject5.getInteger("TraceStatus");//3
            String traceStatusText = jsonObject5.getString("TraceStatusText");//3

            if (traceStatus == 3) {

                return 1;
            }


            String s1 = erpQueyServiceI.queryTrackerNO(expressNo);


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

                if (date.compareTo(lastDate) > 0) {
                    lastDate = date;
                }
            }

            Calendar c = Calendar.getInstance();
            Date date = c.getTime();
            SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parse = null;

            try {
                parse = simple.parse(lastDate);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            // 包裹类型
            int a = (int) ((date.getTime() - parse.getTime()) / (1000 * 3600 * 24));

            if (a < 8) {

                // 正常
                return 2;
            }


            // todo 8-30 天的物流状态怎么处理

            //3 ,长期不更行  ，，丢包和未丢包两种情况

            // 快递
            if (!"经济小包".equals(shippingTypeName)) {
                if (a > 30) {
                    return 3;
                }
            } else {

                if (a > 45) {
                    return 3;
                }
            }
            // todo 小包类型和其他快递的名称

        } catch (Exception e) {
            e.printStackTrace();
        }


        return result_int;

    }


}
