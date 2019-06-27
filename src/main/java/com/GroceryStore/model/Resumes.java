package com.GroceryStore.model;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/15 
//Time: 12:07
//To change this template use File | Settings | File Templates.
public class Resumes {
    private int resId;
    private int jobId;
    private int jobBuyId;
    private String resContent;
    private String resApplicantName;
    private int resApplicantSex;
    private String resApplicantAge;
    private int resApplicantEdu;
    private int resApplicantExp;
    private String resApplicantTel;

    public int getResState() {
        return resState;
    }

    public void setResState(int resState) {
        this.resState = resState;
    }

    private int resState;


    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getJobBuyId() {
        return jobBuyId;
    }

    public void setJobBuyId(int jobBuyId) {
        this.jobBuyId = jobBuyId;
    }

    public String getResContent(String resContent) {
        return this.resContent;
    }

    public void setResContent(String resContent) {
        this.resContent = resContent;
    }


    public String getResContent() {
        return resContent;
    }

    public String getResApplicantName() {
        return resApplicantName;
    }

    public void setResApplicantName(String resApplicantName) {
        this.resApplicantName = resApplicantName;
    }

    public int getResApplicantSex() {
        return resApplicantSex;
    }

    public void setResApplicantSex(int resApplicantSex) {
        this.resApplicantSex = resApplicantSex;
    }

    public String getResApplicantAge() {
        return resApplicantAge;
    }

    public void setResApplicantAge(String resApplicantAge) {
        this.resApplicantAge = resApplicantAge;
    }

    public int getResApplicantEdu() {
        return resApplicantEdu;
    }

    public void setResApplicantEdu(int resApplicantEdu) {
        this.resApplicantEdu = resApplicantEdu;
    }

    public int getResApplicantExp() {
        return resApplicantExp;
    }

    public void setResApplicantExp(int resApplicantExp) {
        this.resApplicantExp = resApplicantExp;
    }

    public String getResApplicantTel() {
        return resApplicantTel;
    }

    public void setResApplicantTel(String resApplicantTel) {
        this.resApplicantTel = resApplicantTel;
    }
}
