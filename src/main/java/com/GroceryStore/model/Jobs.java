package com.GroceryStore.model;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/12 
//Time: 17:44
//To change this template use File | Settings | File Templates.
public class Jobs {
    private int jobId;//兼职编号
    private String jobName;//兼职名称
    private String jobTime;//兼职时间
    private int jobAddress;//兼职地点
    private String jobIntro;//兼职简介
    private int jobSort;//兼职类别
    private int jobEmployerId;//兼职雇主
    private int jobEmployeeId;//兼职雇员
    private int jobState;//兼职状态
    private String jobPrice;//兼职价格
    private int jobSex;//兼职要求的性别
    private int jobEdu;//兼职要求的学历
    private int jobAge;//兼职要求的年龄

    public Jobs() {
    }

    public int getJobEmployerId() {
        return jobEmployerId;
    }

    public void setJobEmployerId(int jobEmployerId) {
        this.jobEmployerId = jobEmployerId;
    }

    public int getJobEmployeeId() {
        return jobEmployeeId;
    }

    public void setJobEmployeeId(int jobEmployeeId) {
        this.jobEmployeeId = jobEmployeeId;
    }

    public String getJobPrice() {
        return jobPrice;
    }

    public void setJobPrice(String jobPrice) {
        this.jobPrice = jobPrice;
    }

    public int getJobSex() {
        return jobSex;
    }

    public void setJobSex(int jobSex) {
        this.jobSex = jobSex;
    }

    public int getJobEdu() {
        return jobEdu;
    }

    public void setJobEdu(int jobEdu) {
        this.jobEdu = jobEdu;
    }

    public int getJobAge() {
        return jobAge;
    }

    public void setJobAge(int jobAge) {
        this.jobAge = jobAge;
    }

    public int getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(int jobAddress) {
        this.jobAddress = jobAddress;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getJobSort() {
        return jobSort;
    }

    public void setJobSort(int jobSort) {
        this.jobSort = jobSort;
    }

    public String getJobTime() {
        return jobTime;
    }

    public void setJobTime(String jobTime) {
        this.jobTime = jobTime;
    }

    public String getJobIntro() {
        return jobIntro;
    }

    public void setJobIntro(String jobIntro) {
        this.jobIntro = jobIntro;
    }

    public int getJobState() {
        return jobState;
    }

    public void setJobState(int jobState) {
        this.jobState = jobState;
    }
}
