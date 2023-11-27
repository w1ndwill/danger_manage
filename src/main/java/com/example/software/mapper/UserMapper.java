package com.example.software.mapper;

import com.example.software.bean.Info;
import com.example.software.bean.UserBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    UserBean getInfo(String name,String password);
    //UserBean insertInfo(String name, String password, String truename, int identity );
    int insertInfo(UserBean user);
    String getUserIdByUsernameAndPassword(@Param("name") String username, @Param("password") String password);
    boolean checkUserExists(String name);
    boolean checkAuthCode(String authCode, int identity);

    UserBean getname(String name);
    List<UserBean> getAllUser();

    void deleteUser(UserBean user);

}