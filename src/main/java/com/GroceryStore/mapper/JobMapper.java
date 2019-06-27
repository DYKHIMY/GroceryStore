package com.GroceryStore.mapper;

import com.GroceryStore.model.Jobs;
import com.GroceryStore.model.Resumes;
import java.util.List;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/14
//Time: 11:58
//To change this template use File | Settings | File Templates.
public interface JobMapper {
    int addJob (Jobs job);
    List<Jobs> listJob();
    int deleteJob(int jid);
    int updateJob(Jobs job);
    List<Jobs> findByName(String jname);
    Jobs selectJob(int jid);
    //出手之后兼职state的变化
    int updateJobByState(Jobs job);
    int findByState(int jobid);
    List<Jobs> selectJobByUser(int userid);
    //关于简历部分的功能
    int addResume (Resumes resumes);
    List<Resumes> findResumeByJobId (int jid);
    Resumes selectOneResume(int resid);
    List<Jobs> selectResumeJob(int userid);
    List<Jobs> selectJobByReq(Jobs jobs);
}
