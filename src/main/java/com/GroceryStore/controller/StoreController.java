package com.GroceryStore.controller;

import com.GroceryStore.model.Goods;
import com.GroceryStore.model.Jobs;
import com.GroceryStore.service.StoreService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.nativejdbc.OracleJdbc4NativeJdbcExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/11
//Time: 21:14
//To change this template use File | Settings | File Templates.
@Controller
@RequestMapping("Store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    public StoreController(){}

    /*
    获取所有商品(未售出)
     */
    @RequestMapping(value = "getAllGoods")
    @ResponseBody
    public Map<String, Object> getAllGoods(String pageNum){
        int num=Integer.valueOf(pageNum);//点击了哪页
        int ep=16;//每页条数
        List<Goods> list= storeService.selectAllGoods();
        List<Goods> list1=new ArrayList<Goods>();
        int N=(list.size()+ep-1)/ep;//总页数
        for(int i=0;i<ep;i++){
            if((num*ep+i-ep)<list.size()) {
                list1.add(list.get(num*ep+i-ep));
            }else{
                break;
            }
        }
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("list",list1);
        map.put("total",list.size());
        map.put("pagenum",N);
        return map;

    }
    /*
    获取一个商品（ById）
     */
    @RequestMapping(value = "getGoodById")
    @ResponseBody
    public JSONObject getGoodById(String goodid){
        Goods good=storeService.selectGood(goodid);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("good",good);
        return jsonObject;
    }
    /*
    购买一个商品
     */
    @RequestMapping(value = "buyGood")
    @ResponseBody
    public JSONObject buyGood(String goodid,String buyerid){
        int state=storeService.selectState(goodid);
        JSONObject jsonObject=new JSONObject();
        int isSucceed = 0;
        if (state==0){//如果未售出
            state=1;
            isSucceed=storeService.changeGoodByStateSell(goodid,state,buyerid);//修改商品状态和买家
        }
        jsonObject.put("isSucceed",isSucceed);
        return jsonObject;
    }
    /*
    删除一个商品
     */
    @RequestMapping(value = "deleteGood")
    @ResponseBody
    public JSONObject deleteGood(String goodid){
        storeService.deleteGood(goodid);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("isSucceed",1);
        return jsonObject;
    }
    /*
    修改商品信息
     */
    @RequestMapping(value = "changeGood" )
    @ResponseBody
    public int changeGood(@RequestParam(value = "imgs")MultipartFile[] imgs,String goodid,String name,String sort,String price,String time,String intro){
        int isSucceed= 0;
        try {
            isSucceed = storeService.changeGood(imgs,goodid,name,sort,price,time,intro);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  isSucceed;
    }
    /**
     *添加商品（配图片）
     */
    @RequestMapping(value = "/addImg",method = RequestMethod.POST)
    @ResponseBody
    public int addImg(@RequestParam(value = "imgs")MultipartFile[] imgs,String name,String sort,String price,String time,String intro,String sellId) throws IOException {
        int isSucceed=0;
        try{
            Goods goods=new Goods();
            goods.setGoodName(name);
            goods.setGoodSort(Integer.parseInt(sort));
            goods.setGoodTime(time);
            goods.setGoodIntro(intro);
            goods.setGoodPrice(Double.parseDouble(price));
            goods.setGoodSellId(Integer.parseInt(sellId));
            goods.setGoodState(0);
            isSucceed=storeService.addImg(imgs,goods);
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("isSucceed",isSucceed);
            return isSucceed;
        }catch (IOException e){
            e.printStackTrace();
        }
        return isSucceed;
    }
    /*
    获取已购买的商品
     */
    @RequestMapping("selectGoodByBuy")
    @ResponseBody
    public Map<String,Object> selectGoodByUser(String buyid,String pageNum){
        int num=Integer.valueOf(pageNum);//点击了哪页
        int ep=16;//每页条数
        List<Goods> list= storeService.selectGoodByUser(buyid);
        List<Goods> list1=new ArrayList<Goods>();
        int N=(list.size()+ep-1)/ep;//总页数
        for(int i=0;i<ep;i++){
            if((num*ep+i-ep)<list.size()) {
                list1.add(list.get(num*ep+i-ep));
            }else{
                break;
            }
        }
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("list",list1);
        map.put("total",list.size());
        map.put("pagenum",N);
        return map;

    }

    /*
    获取已发布的商品
     */
    @RequestMapping("selectGoodBySell")
    @ResponseBody
    public Map<String,Object> selectGoodBySell(String sellid,String pageNum) {
        int num=Integer.valueOf(pageNum);//点击了哪页
        int ep=16;//每页条数
        List<Goods> list= storeService.selectGoodBySell(sellid);
        List<Goods> list1=new ArrayList<>();
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
    类别查询
     */
    @RequestMapping("selectGoodBySort")
    @ResponseBody
    public Map<String,Object> selectGoodBySort(String sortid,String pageNum) {
        int num=Integer.valueOf(pageNum);//点击了哪页
        int ep=16;//每页条数
        List<Goods> list= storeService.selectGoodBySort(sortid);
        List<Goods> list1=new ArrayList<>();
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
    模糊查询
     */
    @RequestMapping("selectGoodsByName")
    @ResponseBody
    public Map<String,Object> selectGoodsByName(String pageNum,String str){
        int number = Integer.parseInt(pageNum);
        int ep = 10;
        List<Goods> list = storeService.selectGoodsByName(str);
        List<Goods> list2 = new ArrayList<>();
        int N = (list.size() + ep - 1) / ep;//总页数
        for (int i = 0; i < ep; i++) {
            if ((number * ep + i - ep) < list.size()) {
                list2.add(list.get(number * ep + i - ep));
            } else {
                break;
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("list", list2);
        map.put("total", list.size());
        map.put("pagenum", N);
        return map;
    }
}

