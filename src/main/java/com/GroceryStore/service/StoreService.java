package com.GroceryStore.service;

import com.GroceryStore.mapper.StoreMapper;
import com.GroceryStore.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/12
//Time: 12:46
//To change this template use File | Settings | File Templates.
@Service
public class StoreService {
    @Autowired
    private StoreMapper storeMapper;

    /*
    查询所有商品
     */
    public List<Goods> selectAllGoods(){
        List<Goods> list=storeMapper.selectAllGoods();
        return list;
    }
    /*
    查询一个商品
     */
    public Goods selectGood(String id){
        int goodId=Integer.parseInt(id);
        Goods good=storeMapper.selectGood(goodId);
        return good;
    }
    /*
    添加商品
     */
    public int addGood(String name,int sort,String time,String intro,double price,int sellid){
        Goods goods=new Goods();
        goods.setGoodName(name);
        goods.setGoodIntro(intro);
        goods.setGoodPrice(price);
        goods.setGoodSort(sort);
        goods.setGoodState(0);//设置状态未售出
        goods.setGoodTime(time);
        goods.setGoodSellId(sellid);
        int isSucceed=storeMapper.addGood(goods);
        return isSucceed;
    }
    /*
    更改商品状态&买家（购买商品）
     */
    public int changeGoodByStateSell(String goodid,int state,String buyerid){
        int gid=Integer.parseInt(goodid);
        int buyid=Integer.parseInt(buyerid);
        Goods goods=new Goods();
        goods.setGoodId(gid);
        goods.setGoodState(state);
        goods.setGoodBuyId(buyid);
        int isSucceed=storeMapper.changeGoodByStateSell(goods);
        return isSucceed;
    }

    /*
    查商品状态
     */
    public int selectState(String goodid){
        int gid=Integer.parseInt(goodid);
        int state=storeMapper.selectState(gid);
        return state;
    }
    /*
    删除一个商品
     */
    public void deleteGood(String id){
        int goodid=Integer.parseInt(id);
        storeMapper.deleteGood(goodid);
    }
    /*
    修改商品信息
     */
    public int changeGood(MultipartFile[] imgs,String goodid,String name,String sort,String price,String time,String intro) throws IOException {
        Goods goods=selectGood(goodid);
        MultipartFile[] m=new MultipartFile[5];
        System.arraycopy(imgs,0,m,0,imgs.length);
        imgs=java.util.Arrays.copyOf(imgs,5);
        goods.setGoodName(name);
        goods.setGoodSort(Integer.parseInt(sort));
        goods.setGoodPrice(Double.parseDouble(price));
        goods.setGoodTime(time);
        goods.setGoodIntro(intro);
        if(imgs!=null&&imgs.length>0){
            String[] path=new String[imgs.length];
            for (int i=0;i<imgs.length;i++){
                path[i]=this.picPathUtil(imgs[i]);
            }
            goods.setGoodImg1(path[0]);
            goods.setGoodImg2(path[1]);
            goods.setGoodImg3(path[2]);
            goods.setGoodImg4(path[3]);
            goods.setGoodImg5(path[4]);
        }
        int i=storeMapper.changeGood(goods);
        return i;
    }
    /*
     * 添加商品（上传图片）
     */
    public int addImg(MultipartFile[] imgs,Goods good)throws IOException{
        if(imgs!=null&&imgs.length>0){
            String[] path=new String[5];
            for (int i=0;i<imgs.length;i++){
                path[i]=this.picPathUtil(imgs[i]);
            }
            good.setGoodImg1(path[0]);
            good.setGoodImg2(path[1]);
            good.setGoodImg3(path[2]);
            good.setGoodImg4(path[3]);
            good.setGoodImg5(path[4]);
        }
        int i=storeMapper.addImg(good);
        return i;
    }
    public String picPathUtil(MultipartFile img) throws IOException {
        // 保存图片的路径，图片上传成功后，将路径保存到数据库
        String filePath = "D:\\idea代码\\GroceryStore\\src\\main\\webapp\\Img";
        try {
            // 获取原始图片的扩展名
            String originalFilename = img.getOriginalFilename();
            // 生成文件新的名字
            String newFileName = UUID.randomUUID() + originalFilename;
            // 封装上传文件位置的全路径
            File targetFile = new File(filePath, newFileName);
            img.transferTo(targetFile);
            return newFileName;
        }catch (NullPointerException e){
            e.printStackTrace();
            return "";

        }
    }
    public List<Goods> selectGoodByUser(String buyid){
        List<Goods> list=storeMapper.selectGoodByUser(Integer.parseInt(buyid));
        return list;
    }

    public List<Goods> selectGoodBySell(String sellid){
        List<Goods> list=storeMapper.selectGoodBySell(Integer.parseInt(sellid));
        return list;
    }

    public List<Goods> selectGoodBySort(String sortid){
        List<Goods> list=storeMapper.selectGoodBySort(Integer.parseInt(sortid));
        return list;
    }
    public List<Goods> selectGoodsByName(String str){
        return storeMapper.selectGoodsByName(str);
    }
}
