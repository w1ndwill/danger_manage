package com.example.software.mapper;

import com.example.software.bean.UserBean;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    UserBean getInfo(String name,String password);
    //UserBean insertInfo(String name, String password, String truename, int identity );
    int insertInfo(UserBean user);
    String getUserIdByUsernameAndPassword(@Param("name") String username, @Param("password") String password);
    boolean checkUserExists(String name);
    boolean checkAuthCode(String authCode, int identity);
}