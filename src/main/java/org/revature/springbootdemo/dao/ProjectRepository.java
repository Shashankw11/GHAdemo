package org.revature.springbootdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.revature.springbootdemo.models.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
