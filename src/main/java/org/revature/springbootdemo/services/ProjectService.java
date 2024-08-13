package org.revature.springbootdemo.services;

import org.revature.springbootdemo.dao.ProjectRepository;

import org.revature.springbootdemo.models.Project;
import org.revature.springbootdemo.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProject(){
        return projectRepository.findAll();

    }

    public Project addProject(Project project){
        projectRepository.save(project);
        return project;
    }

    public Optional<Project> getProjectById(long project_id) {
        return projectRepository.findById(project_id);
    }

    public Project updateProject(Project project){
        projectRepository.save(project);
        return project;
    }

    public Project deleteProject(long project_id){
        Optional<Project> project = getProjectById(project_id);
        projectRepository.deleteById(project_id);
        return project.get();
    }

    public List<Task> getTaskByProjectId(long project_id){
        return new ArrayList<>(projectRepository.findById(project_id).get().getTask());
    }

}
