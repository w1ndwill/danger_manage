package com.example.software.serviceImpl;

import com.example.software.bean.Task;
import com.example.software.mapper.TaskMapper;
import com.example.software.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<Task> AllTasks() {
        return taskMapper.getAllTasks();
    }
}
