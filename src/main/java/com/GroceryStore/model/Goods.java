package com.GroceryStore.model;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/12 
//Time: 15:46
//To change this template use File | Settings | File Templates.
public class Goods {
    private int goodId;
    private String goodName;
    private int goodSort;
    private String goodTime;
    private String goodIntro;
    private double goodPrice;
    private int goodState;
    private int goodSellId;
    private int goodBuyId;
    private String goodImg1;
    private String goodImg2;
    private String goodImg3;
    private String goodImg4;
    private String goodImg5;


    public Goods() {
    }

    public Goods(int goodId, String goodName, int goodSort, String goodTime, String goodIntro, double goodPrice, int goodState,
                 int goodSellId, int goodBuyId, String goodImg1, String goodImg2, String goodImg3, String goodImg4, String goodImg5) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.goodSort = goodSort;
        this.goodTime = goodTime;
        this.goodIntro = goodIntro;
        this.goodPrice = goodPrice;
        this.goodState = goodState;
        this.goodSellId = goodSellId;
        this.goodBuyId = goodBuyId;
        this.goodImg1 = goodImg1;
        this.goodImg2 = goodImg2;
        this.goodImg3 = goodImg3;
        this.goodImg4 = goodImg4;
        this.goodImg5 = goodImg5;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getGoodSort() {
        return goodSort;
    }

    public void setGoodSort(int goodSort) {
        this.goodSort = goodSort;
    }

    public String getGoodTime() {
        return goodTime;
    }

    public void setGoodTime(String goodTime) {
        this.goodTime = goodTime;
    }

    public String getGoodIntro() {
        return goodIntro;
    }

    public void setGoodIntro(String goodIntro) {
        this.goodIntro = goodIntro;
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public int getGoodState() {
        return goodState;
    }

    public void setGoodState(int goodState) {
        this.goodState = goodState;
    }

    public int getGoodSellId() {
        return goodSellId;
    }

    public void setGoodSellId(int goodSellId) {
        this.goodSellId = goodSellId;
    }

    public int getGoodBuyId() {
        return goodBuyId;
    }

    public void setGoodBuyId(int goodBuyId) {
        this.goodBuyId = goodBuyId;
    }

    public String getGoodImg1() {
        return goodImg1;
    }

    public void setGoodImg1(String goodImg1) {
        this.goodImg1 = goodImg1;
    }

    public String getGoodImg2() {
        return goodImg2;
    }

    public void setGoodImg2(String goodImg2) {
        this.goodImg2 = goodImg2;
    }

    public String getGoodImg3() {
        return goodImg3;
    }

    public void setGoodImg3(String goodImg3) {
        this.goodImg3 = goodImg3;
    }

    public String getGoodImg4() {
        return goodImg4;
    }

    public void setGoodImg4(String goodImg4) {
        this.goodImg4 = goodImg4;
    }

    public String getGoodImg5() {
        return goodImg5;
    }

    public void setGoodImg5(String goodImg5) {
        this.goodImg5 = goodImg5;
    }
}
