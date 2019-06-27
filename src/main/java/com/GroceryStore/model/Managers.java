package com.GroceryStore.model;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/12 
//Time: 18:17
//To change this template use File | Settings | File Templates.
public class Managers {
    private int managerId;
    private String managerName;
    private String managerPassword;

    public Managers() {
    }

    public Managers(int managerId, String managerName, String managerPassword) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerPassword = managerPassword;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword;
    }
}
