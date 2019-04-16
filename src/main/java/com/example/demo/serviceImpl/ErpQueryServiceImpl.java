package com.example.demo.serviceImpl;

import com.example.demo.service.ErpQueyServiceI;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import static com.example.demo.utils.Http.*;

@Service
public class ErpQueryServiceImpl implements ErpQueyServiceI {


    // todo  把这些常量的访问url 统一管理起来

    private static final String url_1 = "http://api-erp.orderplus.com/api/order/GetOrderDetailsByCallCenter";


    private static final String url_2 = "http://api-erp.orderplus.com//api/order/GetLogisticsInfoByCallCenter";

    private static final String url_3 = "http://api-erp.orderplus.com/api/order/GetLogsticsInfoByExpressNoForCallCenter";


    private static final String url_4 = "http://logistics.orderplus.com/api/tracker/create";
    private static final String url_5 = "http://logistics.orderplus.com/api/tracker/trackorder";


    @Override
    public String queryInfoByTx(String tx) {
        String sss = "{\"Tx\" : \"" + tx + "\"}";
        String s = httpPostRaw(url_1, sss, new HashMap<String, String>(), null);
        return s;
    }


    public String queryByOrderNoAndSiteID(String orderNo, String siteID) {


        String my_parmsa = "{\n" +
                "  \"OrderNo\":\" " + orderNo + "\",\n" +
                "  \"SiteId\":\"" + siteID + "\"\n" +
                "}";
        String my_pars = "{ \"OrderNo\":\""+orderNo+"\",\"SiteId\":\""+siteID+"\"}";



        String s = httpPostRaw(url_2, my_pars, new HashMap<String, String>(), null);

        return  s;

/*

        String tempString = "{\n" +
                "    \"code\": 200,\n" +
                "    \"success\": true,\n" +
                "    \"error\": null,\n" +
                "    \"message\": \"success\",\n" +
                "    \"response\": [\n" +
                "        {\n" +
                "            \"OrderNo\": \"JGP-12072SA\",\n" +
                "            \"PackageList\": [\n" +
                "                {\n" +
                "                    \"PackageId\": 0,\n" +
                "                    \"PackageStatusList\": [\n" +
                "                        {\n" +
                "                            \"Status\": 0,\n" +
                "                            \"StatusText\": \"已下单\",\n" +
                "                            \"IsExpect\": false,\n" +
                "                            \"CreateTime\": \"2019-04-13T16:18:10\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Status\": 1,\n" +
                "                            \"StatusText\": \"备货中\",\n" +
                "                            \"IsExpect\": true,\n" +
                "                            \"CreateTime\": \"2019-04-20T16:18:10\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Status\": 2,\n" +
                "                            \"StatusText\": \"待发货\",\n" +
                "                            \"IsExpect\": true,\n" +
                "                            \"CreateTime\": \"2019-04-21T16:18:10\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"Status\": 3,\n" +
                "                            \"StatusText\": \"已发货\",\n" +
                "                            \"IsExpect\": true,\n" +
                "                            \"CreateTime\": \"2019-04-22T16:18:10\"\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"goodsList\": [\n" +
                "                        {\n" +
                "                            \"GoodsId\": 0,\n" +
                "                            \"SpuId\": 3378055,\n" +
                "                            \"SkuId\": 6808753,\n" +
                "                            \"ThumbnailsUrl\": \"http://pms-hk.aopcdn.com/orgin/337/3378/33780/3378055_d496743e71.jpg?x-oss-process=image/resize,m_lfit,h_240,w_180\",\n" +
                "                            \"Title\": \"\",\n" +
                "                            \"Price\": 22.1,\n" +
                "                            \"CurrencyPrice\": 22.1,\n" +
                "                            \"IsDistribution\": false,\n" +
                "                            \"IsLockStock\": false,\n" +
                "                            \"IsInPackage\": false,\n" +
                "                            \"IsDelivery\": false\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"GoodsId\": 0,\n" +
                "                            \"SpuId\": 3372945,\n" +
                "                            \"SkuId\": 6747810,\n" +
                "                            \"ThumbnailsUrl\": \"http://pms-hk.aopcdn.com/orgin/337/3372/33729/3372945_65e95d9d07.png?x-oss-process=image/resize,m_lfit,h_240,w_180\",\n" +
                "                            \"Title\": \"\",\n" +
                "                            \"Price\": 23.36,\n" +
                "                            \"CurrencyPrice\": 23.36,\n" +
                "                            \"IsDistribution\": false,\n" +
                "                            \"IsLockStock\": false,\n" +
                "                            \"IsInPackage\": false,\n" +
                "                            \"IsDelivery\": false\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"GoodsId\": 0,\n" +
                "                            \"SpuId\": 3370677,\n" +
                "                            \"SkuId\": 6723803,\n" +
                "                            \"ThumbnailsUrl\": \"http://pms-hk.aopcdn.com/orgin/337/3370/33706/3370677_04bbad6b52.jpg?x-oss-process=image/resize,m_lfit,h_240,w_180\",\n" +
                "                            \"Title\": \"\",\n" +
                "                            \"Price\": 31.1,\n" +
                "                            \"CurrencyPrice\": 31.1,\n" +
                "                            \"IsDistribution\": false,\n" +
                "                            \"IsLockStock\": false,\n" +
                "                            \"IsInPackage\": false,\n" +
                "                            \"IsDelivery\": false\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"GoodsId\": 0,\n" +
                "                            \"SpuId\": 3380748,\n" +
                "                            \"SkuId\": 6836007,\n" +
                "                            \"ThumbnailsUrl\": \"http://pms-hk.aopcdn.com/orgin/338/3380/33807/3380748_39528d1dad.jpg?x-oss-process=image/resize,m_lfit,h_240,w_180\",\n" +
                "                            \"Title\": \"\",\n" +
                "                            \"Price\": 25.15,\n" +
                "                            \"CurrencyPrice\": 25.15,\n" +
                "                            \"IsDistribution\": false,\n" +
                "                            \"IsLockStock\": false,\n" +
                "                            \"IsInPackage\": false,\n" +
                "                            \"IsDelivery\": false\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"ExpressNo\": \"0\",\n" +
                "                    \"Description\": \"NotInPackage\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"ticks\": 0,\n" +
                "    \"status\": 1\n" +
                "}";



        return tempString;
        */

    }


    public String queryByExpressNO(String expressNo) {
        StringBuffer params_2 = new StringBuffer("ExpressNo=");
        params_2.append(expressNo);
        String s = doPostSimpleParams(url_3, params_2);

        return s;
    }


    /**
     * 创建查询
     *
     * @param tracking_number
     * @return
     */
    public String createTrackerNO(String tracking_number) {

        String queryUrl = url_4 + "?tracking_number=" + tracking_number;
        String s = doGetNoParams(queryUrl);
        return s;
    }


    public String queryTrackerNO(String tracking_number) {

        String query_url = url_5 + "?tracking_number=" + tracking_number;

        String s = doGetNoParams(query_url);

        return s;

/*


      String  tempString = "{\n" +
              "    \"tracking_number\": \"74890983244680012879\",\n" +
              "    \"carrier_code\": \"fedex\",\n" +
              "    \"status\": \"notfound\",\n" +
              "    \"itemTimeLength\": null,\n" +
              "    \"original_country\": \"United States\",\n" +
              "    \"destination_country\": \"United States\",\n" +
              "    \"origin_info\": {\n" +
              "        \"phone\": null,\n" +
              "        \"carrier_code\": \"fedex\",\n" +
              "        \"trackinfo\": [\n" +
              "            {\n" +
              "                \"Details\": \"\",\n" +
              "                \"Date\": \"2019-04-12 05:30:23\",\n" +
              "                \"StatusDescription\": \"Shipment information sent to FedEx\",\n" +
              "                \"checkpoint_status\": \"transit\"\n" +
              "            }\n" +
              "        ]\n" +
              "    },\n" +
              "    \"destination_info\": null\n" +
              "}";

      return  tempString;
*/


    }


}
