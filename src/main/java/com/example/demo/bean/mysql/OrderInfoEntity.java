package com.example.demo.bean.mysql;

public class OrderInfoEntity {

    private int TotalCount = 0;

    private int PageIndex;

    private int PageSize;


}


class OrderStateEntity {

    private String OrderNo;
    private int OrderGoodsCount;
    private String Receiver;
    private String Email;
    private String Tx;
    private String SiteName;
    private int SiteId;
    private int GoodsCount;
    private int OrderStatus;
    private String OrderStatusName;

    // todo 询问价格是否可以用double
    private Double goods_price;
    private String final_price;
    private String discount_price;
    private Double shipping_price;
    private Double GoodsPrice;
    private Double FinalPrice;
    private Double DiscountPrice;

    //            Currency: {
//        Name: USD,
//                Description: 美金,
//                Symbol: ＄,
//                Id: 2,
//                CreateUserName: 管理员,
//                CreateTime: 2015-05-04T11:58:12.497,
//                UpdateUserName: 管理员,
//                UpdateTime; 2015-05-04T11:58:12.497
//    },
    private int PayType;
    private String PayTypeName;
    private String PayTime;
    private String ShippingPrice;
    private String OrderRemark;
    private int ShippingType;

    private String ShippingTypeName;
    private String Address;
    private String City;
    private String State;
    private String Country;
    private String ZipCode;
    private String PhoneNumber;


}
