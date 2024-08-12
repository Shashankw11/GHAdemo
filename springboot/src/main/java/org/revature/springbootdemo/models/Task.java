package org.revature.springbootdemo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long task_id;

    @Column(name = "task_name")
    private String task_name;

    @Column(name = "task_description")
    private String task_description;

    @Column(name = "project")
    private long project;


public Task(){}

    public Task(long task_id, String task_name, String task_description, long project) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.task_description = task_description;
        this.project = project;
    }

    public long getTask_id() {
        return task_id;
    }

    public void setTask_id(long task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public long getProject() {
        return project;
    }

    public void setProject(long project) {
        this.project = project;
    }
}
