package com.example.software.controller;

import com.example.software.bean.Task;
import com.example.software.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    TaskMapper taskMapper;
    @GetMapping("/all")
    public List<Task> getAllTasks() {
            List all=taskMapper.getAllTasks();
            return all;
    }
}
