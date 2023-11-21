package com.example.software.mapper;

import com.example.software.bean.Official;
import com.example.software.bean.Task;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TaskMapper {
    List<Task> getAllTasks();

    List<Official> getAllofficial();
//    @Delete(" DELETE FROM task WHERE number = #{number}")
    void deleteTask(Task task);
    void updateTask(Task task);
    void addTask(Task task);
    void addchildtask(List<Task> task);
//    void deletechildtask(Task task);
    List<Task> getContent(int number, String inspector);
}
