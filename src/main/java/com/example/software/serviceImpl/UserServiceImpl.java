package com.example.software.serviceImpl;

import com.example.software.bean.UserBean;
import com.example.software.mapper.UserMapper;
import com.example.software.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserBean loginIn(String name, String password) {
        return userMapper.getInfo(name,password);
    }

    @Override
    public boolean checkUserExists(String name) {
        return userMapper.checkUserExists(name);
    }
    @Override
    public boolean register(UserBean user) {
        int result = userMapper.insertInfo(user);
        return result > 0;
    }
    @Override
    public boolean checkAuthCode(String authCode, int identity) {
        return userMapper.checkAuthCode(authCode, identity);
    }

    public String getIdByUsernameAndPassword(String name, String password) {
        return userMapper.getUserIdByUsernameAndPassword(name, password);}
}
