package com.example.software.service;

import com.example.software.bean.UserBean;
import org.apache.catalina.User;

public interface UserService {

    UserBean loginIn(String name,String password);

    boolean register(UserBean user);

    boolean checkUserExists(String name);

    boolean checkAuthCode(String authCode, int identity);

}
