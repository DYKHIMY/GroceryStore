package com.GroceryStore.model;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/12 
//Time: 12:45
//To change this template use File | Settings | File Templates.
public class Users {
    private int userId;
    private String userName;
    private String userPassword;
    private String userTel;
    private int userSex;

    public Users(int userId, String userName, String userPasswprd, String userTel, int userSex) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPasswprd;
        this.userTel = userTel;
        this.userSex = userSex;
    }

    public Users() {}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPasswprd) {
        this.userPassword = userPasswprd;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }
}
