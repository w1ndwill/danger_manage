package com.example.software.bean;

import org.apache.catalina.User;

public class UserBean {
    private int id;
    private String name;
    private String password;
    private String truename;
    private int identity;

    public UserBean(String name, String password, String truename, int identity) {
        this.name = name;
        this.password = password;
        this.truename = truename;
        this.identity = identity;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTruename() {
        return truename;
    }
    public void setTruename(String truename) {
        this.truename = truename;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //getter and setter methods
    public int getIdentity() {
        return identity;
    }
    public void setIdentity(int identity) {
        this.identity = identity;
    }


}
