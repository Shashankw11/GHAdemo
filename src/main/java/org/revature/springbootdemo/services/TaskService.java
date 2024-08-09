package org.revature.springbootdemo.services;


import org.revature.springbootdemo.dao.TaskRepository;
import org.revature.springbootdemo.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    public Optional<Task> getTaskById(long task_id){
        return taskRepository.findById(task_id);
    }

    public Task updateTask(Task task){
        taskRepository.save(task);
        return task;
    }

    public Task deleteTask(long task_id){
        Optional<Task> task = getTaskById(task_id);
        taskRepository.deleteById(task_id);
        return task.get();
    }

}