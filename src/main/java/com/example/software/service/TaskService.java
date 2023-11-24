package com.example.software.service;

import com.example.software.bean.Official;
import com.example.software.bean.Task;
import java.util.List;

public interface TaskService {
    public List<Task> AllTasks();
    List<Official> Allofficial();
    void deleteTask(Task task);
    void updateTask(Task task);

}
