package com.example.demo.service;


public interface ErpQueyServiceI {


    /**
     * 根据tx 查询订单号和站点id
     */


     String  queryInfoByTx(String tx);


    /**
     * 根据orderId 和站点查询物流单号
     * @param orderNo
     * @param siteID
     * @return
     */
    public String queryByOrderNoAndSiteID(String orderNo,String siteID);


    /**
     *  根据快递单号查询物流信息
     * @param expressNo
     * @return
     */

    String queryByExpressNO(String expressNo);


    /**
     *  根据track_NO 进行查询
     * @param tracking_number
     * @return
     */
    String queryTrackerNO(String tracking_number);


    /**
     *  创建查询
     * @param tracking_number
     * @return
     */
    public  String createTrackerNO(String tracking_number);


}
