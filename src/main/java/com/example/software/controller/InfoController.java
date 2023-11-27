package com.example.software.controller;

import com.example.software.bean.Info;
import com.example.software.bean.Official;
import com.example.software.bean.Task;
import com.example.software.mapper.InfoMapper;
import com.example.software.service.InfoService;
import com.example.software.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class InfoController {
    @Autowired
    InfoMapper infoMapper;
    @Autowired
    private InfoService infoService;
    @GetMapping("/allInfo")
    public List<Task> getAllInfo() {
        List all=infoMapper.getAllInfo();
        //打印信息
        System.out.println("allInfo被调用了");
        return all;
    }

    @PostMapping("/addInfo")
    public ResponseEntity<String> addInfo(@RequestBody Info information) {
        try {
            infoService.addInfo(information);
            System.out.println("addInfo被调用了");
            return ResponseEntity.status(HttpStatus.CREATED).build(); //201
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("addInfo出错了");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
        }
    }

    @DeleteMapping("/deleteInfo")
    public ResponseEntity<String> deleteInfo(@RequestBody Info information) {
        try {
            infoService.deleteInfo(information);
            System.out.println("deleteInfo被调用了");
            return ResponseEntity.status(HttpStatus.CREATED).build(); //201
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("deleteInfo出错了");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
        }
    }

}
