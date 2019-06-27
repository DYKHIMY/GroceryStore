package com.GroceryStore.model;

import java.sql.Timestamp;
import java.util.Date;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/22 
//Time: 10:42
//To change this template use File | Settings | File Templates.
public class Appraise {
    private int appraiseId;
    private String appraiseContent;
    private int goodId;
    private Date appraiseTime;

    public Appraise() {
    }

    public int getAppraiseId() {
        return appraiseId;
    }

    public void setAppraiseId(int appraiseId) {
        this.appraiseId = appraiseId;
    }

    public String getAppraiseContent() {
        return appraiseContent;
    }

    public void setAppraiseContent(String appraiseContent) {
        this.appraiseContent = appraiseContent;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }


    public Date getAppraiseTime() {
        return appraiseTime;
    }

    public void setAppraiseTime(Date appraiseTime) {
        this.appraiseTime = appraiseTime;
    }
}
