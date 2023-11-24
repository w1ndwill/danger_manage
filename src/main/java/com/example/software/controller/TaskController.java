package com.example.software.controller;

import com.example.software.bean.Official;
import com.example.software.bean.Task;
import com.example.software.mapper.TaskMapper;
import com.example.software.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    private TaskService taskService;
    @GetMapping("/all")
    public List<Task> getAllTasks() {
            List all=taskMapper.getAllTasks();
            return all;
    }

    @GetMapping("/allofficial")
    public List<Official> getAllofficial() {
        List allofficial=taskMapper.getAllofficial();
        return allofficial;
    }

    @DeleteMapping("/deleteTask")
    public ResponseEntity<String> deleteTask(@RequestBody Task task) {
        try {
            taskService.deleteTask(task);
            return new ResponseEntity<>("任务删除成功", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("删除任务时出错: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/updateTask")
    public ResponseEntity<String> updateTask(@RequestBody Task editedTask) {
        try {
            // 调用Service层的方法更新任务信息
            taskService.updateTask(editedTask);
            return ResponseEntity.ok("Task updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating task: " + e.getMessage());
        }
    }
    @PostMapping("/addTask")
    public ResponseEntity<String> addTask(@RequestBody Task temporaryTaskForm) {
        try {
            // 调用Service层的方法更新任务信息
            taskMapper.addTask(temporaryTaskForm);
            return ResponseEntity.ok("Task updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating task: " + e.getMessage());
        }
    }

    @PostMapping("/saveData")
    public ResponseEntity<String> addchildtask(@RequestBody List<Task> data) {
        try {
            // 调用Service层的方法更新任务信息
            taskMapper.addchildtask(data);
            return ResponseEntity.ok("Task updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating task: " + e.getMessage());
        }
    }
      @GetMapping("/getContent")
      public List<Task> getDatabaseContent( @RequestParam int number,
                                            @RequestParam String inspector) {
         List xx= taskMapper.getContent(number,inspector);
         return xx;
}
    @PostMapping("/judge1")
    public ResponseEntity<String> updateDatabase(@RequestBody Task task) {
        try {
            // 调用Service层的方法更新任务信息
            taskMapper.incrementCheckCount(task);
            return ResponseEntity.ok("Task  successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating task: " + e.getMessage());
        }

    }

    @PostMapping("/judge2")
    public ResponseEntity<String> updateData(@RequestBody Task task) {
        try {
            // 调用Service层的方法更新任务信息
            taskMapper.incrementHiddenDangerCount(task);
            return ResponseEntity.ok(" updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating task: " + e.getMessage());
        }
    }

    @PostMapping("/addcheck")
    public ResponseEntity<String> addcheck(@RequestBody Task task) {
        try {
            // 调用Service层的方法更新任务信息
            taskMapper.addcheck(task);
            return ResponseEntity.ok("  successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/allcheck")
    public List<Task> getAllcheck() {
        List check=taskMapper.getAllcheck();
        return check;
    }
}
