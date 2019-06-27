package com.GroceryStore.mapper;

import com.GroceryStore.model.Appraise;
import com.GroceryStore.model.Users;

import java.util.List;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/13 
//Time: 22:06
//To change this template use File | Settings | File Templates.
public interface UserMapper {
    Users selectUser(Integer id);
    int insertUser(Users user);
    int deleteUser(Integer id);
    int updateUser(Users user);
    List<Users> selectAll();
    int insertAppraise(Appraise appraise);
    List<Appraise> selectAppraiseBySell(Integer sellerid);
    List<Appraise> selectAppraisesByBuy(Integer buyerid);
    int deleteAppraise(Integer appid);
}
