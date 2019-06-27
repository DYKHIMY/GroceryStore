package com.GroceryStore.controller;

import com.GroceryStore.model.Appraise;
import com.GroceryStore.model.Users;
import com.GroceryStore.service.UserService;
import com.GroceryStore.util.MD5;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/13
//Time: 22:16
//To change this template use File | Settings | File Templates.
@Controller
@RequestMapping("User")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(){}

    @RequestMapping("Login")
    @ResponseBody
    public JSONObject login(String name, String password)  {
        String passwordByMd5 = MD5.MD5(password);
        JSONObject jsonObject=new JSONObject();
        String word;
        if (name == "") {
            word = "请填写用户名";
            jsonObject.put("isSucceed",word);
            return jsonObject;
        }
        if (passwordByMd5 == "") {
            word = "请输入密码";
            jsonObject.put("isSucceed",word);
            return jsonObject;
        }
        //判断登录名和密码
        List<Users> list = userService.selectAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUserName().equals(name)) {
                if (list.get(i).getUserPassword().equals(passwordByMd5)) {
                    word = "12306";
                    String userid=String.valueOf(list.get(i).getUserId());
                    jsonObject.put("userid",userid);
                    jsonObject.put("isSucceed",word);
                    return jsonObject;
                } else {
                    word = "密码输入有误，请重新输入";
                    jsonObject.put("isSucceed",word);
                    return jsonObject;
                }
            }
        }
        word = "用户不存在";
        jsonObject.put("isSucceed",word);
        return jsonObject;
    }

    @RequestMapping("Register")
    @ResponseBody
    public JSONObject insertUser(String name,String password) {
        JSONObject jsonObject=new JSONObject();
        String word="";
        if (password == "") {
            word="密码不能为空";
            jsonObject.put("isSucceed",word);
            return jsonObject;
        }
        if(name==""){
            word="用户名不能为空";
            jsonObject.put("isSucceed",word);
            return jsonObject;
        }
        String passwordByMd5 = MD5.MD5(password);
        //判断是否注册过
        List<Users> list = userService.selectAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUserName().equals(name)) {
                word="用户名已被使用";
                jsonObject.put("isSucceed",word);
                return jsonObject;
            }
        }
        int isSucceed=userService.insertUser(name,passwordByMd5);
        jsonObject.put("isSucceed",isSucceed);
        return jsonObject;
    }

    /*
    查询用户
     */
    @RequestMapping("selectUser")
    @ResponseBody
    public JSONObject selectUser(String userid){
        JSONObject jsonObject=new JSONObject();
        Users user=userService.selectUser(userid);
        jsonObject.put("user",user);
        return jsonObject;
    }

    /*
   修改用户
     */
    @RequestMapping("changeUser")
    @ResponseBody
    public JSONObject changeUser(String userid,String username,String userpassword,String usertel,String usersex){
        int isSucceed=userService.changeUser(userid,username,userpassword,usersex,usertel);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("isSucceed",isSucceed);
        return jsonObject;
    }

    /*
    添加评论
     */
    @RequestMapping("addAppraise")
    @ResponseBody
    public JSONObject addAppraise(String content,String goodid){
        int isSucceed=userService.insertAppraise(content,goodid);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("isSucceed",isSucceed);
        return jsonObject;
    }

    /*
    查询别人对用户的评价
     */
    @RequestMapping("selectApprBySell")
    @ResponseBody
    public  Map<String, Object> selectAllApprBySell(String sellerid,String pageNum){
        int num=Integer.valueOf(pageNum);//点击了哪页
        int ep=16;//每页条数
        List<Appraise> list= userService.selectAppraisesBySell(sellerid);
        List<Appraise> list1=new ArrayList<>();
        int N=(list.size()+ep-1)/ep;//总页数
        for(int i=0;i<ep;i++){
            if((num*ep+i-ep)<list.size()) {
                list1.add(list.get(num*ep+i-ep));
            }else{
                break;
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("list",list1);
        map.put("total",list.size());
        map.put("pagenum",N);
        return map;
    }

    /*
   查询用户对别人的评价
    */
    @RequestMapping("selectApprByBuy")
    @ResponseBody
    public  Map<String, Object> selectAllApprByBuy(String buyerid,String pageNum){
        int num=Integer.valueOf(pageNum);//点击了哪页
        int ep=16;//每页条数
        List<Appraise> list= userService.selectAppraisesByBuy(buyerid);
        List<Appraise> list1=new ArrayList<>();
        int N=(list.size()+ep-1)/ep;//总页数
        for(int i=0;i<ep;i++){
            if((num*ep+i-ep)<list.size()) {
                list1.add(list.get(num*ep+i-ep));
            }else{
                break;
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("list",list1);
        map.put("total",list.size());
        map.put("pagenum",N);
        return map;
    }

    /*
    删除对别人的评价
     */
    @RequestMapping("deleteAppr")
    @ResponseBody
    public JSONObject deleteAppr(String apprid){
        int isSucceed=userService.deleteAppraise(apprid);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("isSucceed",isSucceed);
        return jsonObject;
    }

}
