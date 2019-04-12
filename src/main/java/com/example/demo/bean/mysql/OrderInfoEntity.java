package com.example.demo.bean.mysql;

public class OrderInfoEntity {

    private int TotalCount = 0;

    private int PageIndex;

    private int PageSize;




    private    OrderStateEntity entity;

    public OrderStateEntity getEntity() {
        return entity;
    }

    public void setEntity(OrderStateEntity entity) {
        this.entity = entity;
    }



    public int getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(int totalCount) {
        TotalCount = totalCount;
    }

    public int getPageIndex() {
        return PageIndex;
    }

    public void setPageIndex(int pageIndex) {
        PageIndex = pageIndex;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }






}


