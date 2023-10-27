package com.example.software.mapper;

import com.example.software.bean.UserBean;

public interface UserMapper {
    UserBean getInfo(String name,String password);
}