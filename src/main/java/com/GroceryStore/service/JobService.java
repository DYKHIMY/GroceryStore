package com.GroceryStore.service;

import com.GroceryStore.mapper.JobMapper;
import com.GroceryStore.model.Jobs;
import com.GroceryStore.model.Resumes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/14
//Time: 11:57
//To change this template use File | Settings | File Templates.
@Service
public class JobService {
    @Autowired
    private JobMapper jobMapper;
    /**
     * 增加兼职信息
     */
    public int addJob(String jobname,String jobsort,String jobtime,String jobaddress,String jobintro,String jobuser,String jobprice,String jobsex,String jobedu,String jobage){
        Jobs job=new Jobs();
        int jobuser2=Integer.parseInt(jobuser);
        int jobsex2=Integer.parseInt(jobsex);
        int jobedu2=Integer.parseInt(jobedu);
        int jobage2=Integer.parseInt(jobage);
        int jobsort1=Integer.parseInt(jobsort);
        job.setJobName(jobname);
        job.setJobSort(jobsort1);
        job.setJobTime(jobtime);
        job.setJobAddress(Integer.parseInt(jobaddress));
        job.setJobIntro(jobintro);
        job.setJobEmployerId(jobuser2);
        job.setJobState(0);//添加商品的时候，商品自动设置成未售出的状态
        job.setJobPrice(jobprice);
        job.setJobSex(jobsex2);
        job.setJobEdu(jobedu2);
        job.setJobAge(jobage2);
        int isSucceed=jobMapper.addJob(job);
        return isSucceed;
    }

    /**
     * 显示所有的兼职工作
     */
    public List<Jobs> listJob(){
        List<Jobs> joblist=jobMapper.listJob();
        return joblist;
    }


    /**
     * 根据id删除对应的兼职信息
     */
    public int deleteJob(String jobid) {
        int jid2 = Integer.parseInt(jobid);
//        System.out.println(jid2);
        int i=jobMapper.deleteJob(jid2);
        return i;
    }

    /**
     * 修改某一条兼职信息
     */
    public int updateJob(String jobid,String jobname,String jobsort,String jobtime,String jobaddress,String jobintro,String jobuser,
                         String jobprice,String jobsex,String jobedu,String jobage){
        Jobs job = selectJob(jobid);
        job.setJobName(jobname);
        job.setJobSort(Integer.parseInt(jobsort));
        job.setJobTime(jobtime);
        job.setJobAddress(Integer.parseInt(jobaddress));
        job.setJobIntro(jobintro);
        job.setJobEmployerId(Integer.parseInt(jobuser));
        job.setJobPrice(jobprice);
        job.setJobSex(Integer.parseInt(jobsex));
        job.setJobEdu(Integer.parseInt(jobedu));
        job.setJobAge(Integer.parseInt(jobage));
        int i=jobMapper.updateJob(job);
        return i;
    }

    /**
     *查询一个兼职
     */
    public Jobs selectJob(String jobid){
        int jobId=Integer.parseInt(jobid);
        Jobs job=jobMapper.selectJob(jobId);
        return job;
    }

    /**
     * 模糊查询兼职信息
     */
    public List<Jobs> findByName(String jname){
//        System.out.println(jname);
        return jobMapper.findByName(jname);
    }

    /**
     * 申请兼职增加简历
     */
    public int addResume(String jobId,String jobBuyId,String resContent,String name,String sex,String age,String edu,String exp,String tel){
        Resumes resumes=new Resumes();
        resumes.setJobId(Integer.parseInt(jobId));
        resumes.setJobBuyId(Integer.parseInt(jobBuyId));
        resumes.setResContent(resContent);
        resumes.setResApplicantName(name);
        resumes.setResApplicantSex(Integer.parseInt(sex));
        resumes.setResApplicantAge(age);
        resumes.setResApplicantEdu(Integer.parseInt(edu));
        resumes.setResApplicantExp(Integer.parseInt(exp));
        resumes.setResApplicantTel(tel);
        resumes.setResState(0);
        int isSucceed=jobMapper.addResume(resumes);
        return isSucceed;
    }


    /**
     * 查找一个兼职的所有简历信息
     */
    public List<Resumes> findResumeByJobId(String jobid){
        return jobMapper.findResumeByJobId(Integer.parseInt(jobid));
    }

    /*
    查询一个简历
     */
    public Resumes selectOneResume(String resid){
        return jobMapper.selectOneResume(Integer.parseInt(resid));
    }

    /*
    查找个人申请的兼职
     */
    public List<Jobs> selectResumeJob(String userid){
        List<Jobs> list=jobMapper.selectResumeJob(Integer.parseInt(userid));
        return list;
    }
    /**
     * 更改兼职状态（售出之后）
     */
    public int updateJobByState(String jobid,String employee){
        Jobs job=new Jobs();
        job.setJobId(Integer.parseInt(jobid));
        job.setJobEmployeeId(Integer.parseInt(employee));
        int isSucceed=jobMapper.updateJobByState(job);
        return isSucceed;
    }

    public List<Jobs> selectJobByUser(String userid){
        List<Jobs> list=jobMapper.selectJobByUser(Integer.parseInt(userid));
        return list;
    }
    /**
     * 查看兼职状态
     */
    public int findByState(String jobid){
        int jobid2=Integer.parseInt(jobid);
        int jobstate=jobMapper.findByState(jobid2);
        return jobstate;
    }
    /*
    根据要求搜索
     */
    public List<Jobs> selectJobByReq(String addr,String sex,String edu,String age){
        Jobs jobs=new Jobs();
        jobs.setJobAddress(Integer.parseInt(addr));
        jobs.setJobSex(Integer.parseInt(sex));
        jobs.setJobEdu(Integer.parseInt(edu));
        jobs.setJobAge(Integer.parseInt(age));
        List<Jobs> list=jobMapper.selectJobByReq(jobs) ;
        return list;
    }
}