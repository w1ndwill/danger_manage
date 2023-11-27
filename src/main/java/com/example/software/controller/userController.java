package com.example.software.controller;

import com.example.software.bean.Info;
import com.example.software.bean.Official;
import com.example.software.bean.Task;
import com.example.software.bean.UserBean;
import com.example.software.mapper.InfoMapper;
import com.example.software.mapper.UserMapper;
import com.example.software.service.InfoService;
import com.example.software.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class userController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/allusers")
    public List<Task> getAllusers() {
        List all=userMapper.getAllUser();
        //打印信息
        System.out.println("allusers被调用了");
        return all;
    }

    @DeleteMapping("/deleteuser")
    public ResponseEntity<String> deleteuser(@RequestBody UserBean user) {
        try {
            userMapper.deleteUser(user);
            System.out.println("deleteuser被调用了");
            return ResponseEntity.status(HttpStatus.CREATED).build(); //201
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("deleteuser出错了");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
        }
    }
}
