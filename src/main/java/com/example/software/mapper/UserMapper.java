package com.example.software.mapper;

import com.example.software.bean.UserBean;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    UserBean getInfo(String name,String password);
    String getUserIdByUsernameAndPassword(@Param("name") String username, @Param("password") String password);
}