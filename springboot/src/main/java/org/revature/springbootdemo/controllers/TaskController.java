package org.revature.springbootdemo.controllers;

import org.revature.springbootdemo.models.Task;
import org.revature.springbootdemo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(service.getAllTasks(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return new ResponseEntity<>(service.addTask(task), HttpStatus.CREATED);
    }

    @GetMapping("/{task_id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long task_id){
        return new ResponseEntity<Task>(service.getTaskById(task_id).get(), HttpStatus.OK);
    }

    @PutMapping("/{task_id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        return new ResponseEntity<Task>(service.updateTask(task), HttpStatus.OK);
    }

    @DeleteMapping("/{task_id}")
    public ResponseEntity<Task> deleteTask(@PathVariable long task_id){
        return new ResponseEntity<Task>(service.deleteTask(task_id), HttpStatus.OK);
    }
}
