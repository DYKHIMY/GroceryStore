package com.GroceryStore.service;

import com.GroceryStore.mapper.UserMapper;
import com.GroceryStore.model.Appraise;
import com.GroceryStore.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/13 
//Time: 22:05
//To change this template use File | Settings | File Templates.
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Users selectUser(String id){
        int userId=Integer.parseInt(id);
        Users user=userMapper.selectUser(userId);
        return user;
    }
    public int insertUser(String name,String password) {
        Users user = new Users();
        user.setUserName(name);
        user.setUserPassword(password);
        int isSucceed= userMapper.insertUser(user);
        return isSucceed;
    }
    public void insertManager(String name,String password){
        Users user = new Users();
        user.setUserName(name);
        user.setUserPassword(password);
        userMapper.insertUser(user);
    }
    public void deleteUser(String id){
        int userId=Integer.parseInt(id);
        userMapper.deleteUser(userId);
    }
    public int changeUser(String id,String name,String password,String sex,String tel){
        int userId=Integer.parseInt(id);
        Users user=new Users();
        user.setUserId(userId);
        user.setUserName(name);
        user.setUserPassword(password);
        user.setUserSex(Integer.parseInt(sex));
        user.setUserTel(tel);
        int i=userMapper.updateUser(user);
        return i;
    }
    public List<Users> selectAll(){
        List<Users> list=userMapper.selectAll();
        return list;
    }

    public int insertAppraise(String content,String goodid){
        Date time= new java.sql.Date(new java.util.Date().getTime());
        System.out.println(time);
        Appraise appraise=new Appraise();
        appraise.setAppraiseTime(time);
        appraise.setAppraiseContent(content);
        appraise.setGoodId(Integer.parseInt(goodid));
        int i=userMapper.insertAppraise(appraise);
        return i;
    }
    /*
    查询别人对用户的评价
     */
    public List<Appraise> selectAppraisesBySell(String sellerid){
        List<Appraise> list= userMapper.selectAppraiseBySell(Integer.valueOf(sellerid));
        return list;
    }
    /*
    查询自己对别人的评价
     */
    public List<Appraise> selectAppraisesByBuy(String buyerid){
        List<Appraise> list=userMapper.selectAppraisesByBuy(Integer.valueOf(buyerid));
        return list;
    }
    /*
    删除评论
     */
    public int deleteAppraise(String appid){
        int i=userMapper.deleteAppraise(Integer.valueOf(appid));
        return i;
    }
}
