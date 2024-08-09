//package org.revature.springbootdemo.project;
//
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.MockitoAnnotations;
//import org.revature.springbootdemo.controllers.ProjectController;
//import org.revature.springbootdemo.models.Project;
//import org.revature.springbootdemo.services.ProjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(ProjectController.class)
//public class ProjectMVCTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ProjectService projectService;
//
//    private List<Project> projectsList;
//
//    @BeforeEach
//    public void setup(){
//        MockitoAnnotations.openMocks(this);
//
//        projectsList = new ArrayList<>();
//        Project project1=new Project();
//        project1.setProject_id(1L);
//        project1.setProject_name("MVC PROJECT");
//
//        projectsList.add(project1);
//    }
//
//    @Test
//    public void testGetProjectById(){
//        when(projectService.getProjectById(1L))
//                .thenReturn(Optional.of(projectsList.get(0)));
//
//        try{
//            mockMvc.perform(get("/api/project/1").accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//                    .andExpect(jsonPath("project_name").value("MVC PROJECT"));
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    @Test
//    public void testAllProjects(){
//        when(projectService.getAllProject())
//                .thenReturn(projectsList);
//
//        try{
//            mockMvc.perform(get("/api/project")
//                            .accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//                    .andExpect(jsonPath("$[0].project_name").value("MVC PROJECT"));
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    @Test
//    public void testCreateProject(){
//        try{
//            mockMvc.perform(post("/api/project")
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .content("{\"project_name\":\"project-mock-spring\"}"))
//                    .andExpect(status().isCreated());
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//    }
//}
