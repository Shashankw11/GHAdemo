package org.revature.springbootdemo.controllers;

import org.revature.springbootdemo.models.Project;
import org.revature.springbootdemo.models.Task;
import org.revature.springbootdemo.services.ProjectService;
import org.revature.springbootdemo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService service;
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProject(){
        return new ResponseEntity<>(service.getAllProject(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project){
        return new ResponseEntity<>(service.addProject(project), HttpStatus.CREATED);
    }

    @GetMapping("/{project_id}")
    public ResponseEntity<Project> getProjectById(@PathVariable long project_id) {
        return new ResponseEntity<Project>(service.getProjectById(project_id).get(), HttpStatus.OK);
    }

    @MessageMapping("/send")
    @PutMapping("/{project_id}")
    public ResponseEntity<Project> updateProject(@RequestBody Project project){
        return new ResponseEntity<Project>(service.updateProject(project), HttpStatus.OK);
    }

    @DeleteMapping("/{project_id}")
    public ResponseEntity<Project> deleteProject(@PathVariable long project_id) {
        return new ResponseEntity<Project>(service.deleteProject(project_id), HttpStatus.OK);
    }

    @GetMapping("/{project_id}/task")
    public ResponseEntity<List<Task>> getTaskByProjectId(@PathVariable long project_id){
        List<Task> task1=service.getTaskByProjectId(project_id);
        return new ResponseEntity<>(task1,HttpStatus.OK);
    }

}
