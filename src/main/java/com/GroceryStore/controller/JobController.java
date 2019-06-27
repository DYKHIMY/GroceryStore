package com.GroceryStore.controller;

import com.GroceryStore.model.Appraise;
import com.GroceryStore.model.Jobs;
import com.GroceryStore.model.Resumes;
import com.GroceryStore.service.JobService;
import com.alibaba.fastjson.JSONObject;
import net.sf.json.JsonConfig;
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
//Date: 2019/5/14
//Time: 11:56
//To change this template use File | Settings | File Templates.
@Controller
@RequestMapping("Job")
public class JobController {
    @Autowired
    JobService jobService=new JobService();

    /**
     * 添加兼职信息
     */
    @RequestMapping(value = "addJob")
    @ResponseBody
    public JSONObject addJob(String jobname,String jobsort,String jobtime,String jobaddress,String jobintro,String jobuser,String jobprice,
                             String jobsex,String jobedu,String jobage){
        int isSucceed=jobService.addJob(jobname,jobsort,jobtime,jobaddress,jobintro,jobuser,jobprice,jobsex,jobedu,jobage);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("isSucceed",isSucceed);
        return jsonObject;
    }

    /**
     * 显示所有兼职信息
     */
    @RequestMapping(value = "listJob")
    @ResponseBody
    public Map<String,Object> listJob(String pageNum){
        int num=Integer.valueOf(pageNum);
        int ep=5;
        List<Jobs> list=jobService.listJob();
        List<Jobs> list1=new ArrayList<>();
        int N=(list.size()+ep-1)/ep;//总页数
        for(int i=0;i<ep;i++){
            if((num*ep+i-ep)<list.size()) {
                list1.add(list.get(num*ep+i-ep));
            }else{
                break;
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("list",list1);//每页数据
        map.put("total",list.size());//总数据条数
        map.put("pagenum",N);//总页数
        return map;
    }
    /*
    查询自己发布的兼职
     */
    @RequestMapping(value = "selectJobByUser")
    @ResponseBody
    public Map<String,Object> selectJobByUser(String pageNum,String userid){
        int num=Integer.valueOf(pageNum);
        int ep=5;
        List<Jobs> list=jobService.selectJobByUser(userid);
        List<Jobs> list1=new ArrayList<>();
        int N=(list.size()+ep-1)/ep;//总页数
        for(int i=0;i<ep;i++){
            if((num*ep+i-ep)<list.size()) {
                list1.add(list.get(num*ep+i-ep));
            }else{
                break;
            }
        }
        Map<String,Object> map=new HashMap<>();
        map.put("list",list1);//每页数据
        map.put("total",list.size());//总数据条数
        map.put("pagenum",N);//总页数
        return map;
    }
    /*
    查询一个兼职
     */
    @RequestMapping(value = "selectJob")
    @ResponseBody
    public JSONObject selectJob(String jobid){
        JSONObject jsonObject=new JSONObject();
        Jobs jobs=jobService.selectJob(jobid);
        jsonObject.put("job",jobs);
        return jsonObject;
    }
    /**
     * 删除兼职信息
     */
    @RequestMapping(value = "deleteJob")
    @ResponseBody
    public JSONObject deleteJob(String jobid){
        int isSucceed=jobService.deleteJob(jobid);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("isSucceed",isSucceed);
        return jsonObject;
    }


    /**
     * 修改兼职信息
     */
    @RequestMapping(value = "updateJob")
    @ResponseBody
    public JSONObject updateJob(String jobid,String jobname,String jobsort,String jobtime,String jobaddress,String jobintro,String jobuser,String jobprice,
                                String jobsex,String jobedu,String jobage){
        int isSucceed=0;
        isSucceed=jobService.updateJob(jobid, jobname, jobsort, jobtime, jobaddress, jobintro, jobuser, jobprice, jobsex, jobedu, jobage);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("isSucceed",isSucceed);
        return jsonObject;
    }

    /**
     * 模糊查询兼职信息
     */
    @RequestMapping(value = "selectJobByName")
    @ResponseBody
    public Map<String,Object> selectJobByName(String pageNum,String str) {
        int number = Integer.parseInt(pageNum);
        int ep = 10;
        List<Jobs> list = jobService.findByName(str);//查询的名称字段
        List<Jobs> list2 = new ArrayList<>();
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
    @RequestMapping(value = "selectJobByReq")
    @ResponseBody
    public Map<String,Object> findByName(String pageNum,String addr,String sex,String edu,String age){
        int number = Integer.parseInt(pageNum);
        int ep = 10;
        List<Jobs> list = jobService.selectJobByReq(addr,sex,edu,age);//查询的名称字段
        List<Jobs> list2 = new ArrayList<>();
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
    /**
     * 增加简历
     */
    @RequestMapping(value = "addResume")
    @ResponseBody
    public JSONObject addResume(String jobId,String jobBuyId,String resContent,String name,String sex,String age,String edu,String exp,String tel){
        int isSucceed=jobService.addResume(jobId,jobBuyId,resContent,name,sex,age,edu,exp,tel);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("isSucceed",isSucceed);
        return jsonObject;
    }

    /**
     * 根据兼职id查找提交上来的简历信息
     */
    @RequestMapping(value = "selectResume")
    @ResponseBody
    public Map<String, Object> findByJobId(String jobid,String pageNum){
        int num=Integer.valueOf(pageNum);//点击了哪页
        int ep=16;//每页条数
        List<Resumes> list= jobService.findResumeByJobId(jobid);
        List<Resumes> list1=new ArrayList<>();
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
    查询一个简历
     */
    @RequestMapping("selectOneResume")
    @ResponseBody
    public JSONObject selectOneResume(String resid){
        JSONObject jsonObject=new JSONObject();
        Resumes resume=jobService.selectOneResume(resid);
        jsonObject.put("resume",resume);
        return jsonObject;
    }

    /*
    查找个人申请的兼职
     */
    @RequestMapping("selectResumeJob")
    @ResponseBody
    public Map<String, Object> selectResumeJob(String userid,String pageNum){
        int num=Integer.valueOf(pageNum);//点击了哪页
        int ep=5;//每页条数
        int state0=0;
        List<Jobs> list= jobService.selectResumeJob(userid);
        List<Jobs> list1=new ArrayList<>();
        int N=(list.size()+ep-1)/ep;//总页数
        for(int i=0;i<ep;i++){
            if((num*ep+i-ep)<list.size()) {
                list1.add(list.get(num*ep+i-ep));
            }else{
                break;
            }
        }
        List<Integer> state=new ArrayList<>();
        for (int i=0;i<list1.size();i++){
            if(list1.get(i).getJobState()==1){
                if (list1.get(i).getJobEmployeeId()==Integer.parseInt(userid)){
                    state0=2;//已通过
                }else {
                    state0=list1.get(i).getJobState();//0审核中，1未通过
                }
            }
            state.add(state0);
        }
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("list",list1);
        map.put("total",list.size());
        map.put("pagenum",N);
        map.put("state",state);
        return map;
    }
    /**
     * 更改兼职状态（招聘之后）
     */
    @RequestMapping(value = "getJob")
    @ResponseBody
    public JSONObject buyJob(String jobid,String employee){
        int jobstate=jobService.findByState(jobid);
        JSONObject jsonObject=new JSONObject();
        int isSucceed=0;
        if(jobstate==0){
            isSucceed=jobService.updateJobByState(jobid,employee);
        }
        jsonObject.put("isSucceed",isSucceed);
        return jsonObject;
    }
}
