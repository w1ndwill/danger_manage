package com.example.software.service;

import com.example.software.bean.UserBean;

public interface UserService {

    UserBean loginIn(String name,String password);

    UserBean register(String name,String password,String account);
    String  getIdByUsernameAndPassword(String name, String password);

}
