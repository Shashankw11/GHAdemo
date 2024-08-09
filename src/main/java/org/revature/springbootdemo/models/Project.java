package org.revature.springbootdemo.models;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long project_id;

    @Column(name = "projectName")
    private String project_name;

    @Column(name = "projectDescription")
    private String project_description;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Task> task;

    public Project() {}

    public Project(long project_id, String project_name, String project_description, Set<Task> task) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_description = project_description;
        this.task = task;
    }

    public long getProject_id() {
        return project_id;
    }

    public void setProject_id(long project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }

    public Set<Task> getTask() {
        return task;
    }

    public void setTask(Set<Task> task) {
        this.task = task;
    }
}
