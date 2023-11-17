package com.example.software.serviceImpl;

import com.example.software.bean.Official;
import com.example.software.bean.Task;
import com.example.software.mapper.TaskMapper;
import com.example.software.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<Task> AllTasks() {
        return taskMapper.getAllTasks();
    }
    @Override
    public List<Official> Allofficial(){return taskMapper.getAllofficial();}
    @Override
    public void deleteTask(Task task) {
        taskMapper.deleteTask(task);
    }
    public void updateTask(Task task) {
        taskMapper.updateTask(task);
    }



}
