package com.GroceryStore.mapper;

import com.GroceryStore.model.Goods;

import java.util.List;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/12 
//Time: 12:45
//To change this template use File | Settings | File Templates.
public interface StoreMapper {
    List<Goods> selectAllGoods();
    Goods selectGood(int id);
    int addGood(Goods good);
    int changeGoodByStateSell(Goods goods);
    int selectState(int gid);
    void deleteGood(int id);
    int changeGood(Goods good);
    int addImg(Goods img);
    List<Goods> selectGoodByUser(int buyid);
    List<Goods> selectGoodBySell(int sellid);
    List<Goods> selectGoodBySort(int sortid);
    List<Goods> selectGoodsByName(String goodname);
}
