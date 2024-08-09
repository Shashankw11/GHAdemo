package org.revature.springbootdemo.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class DisplayController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/project")
    @SendTo("/topic/projects")
    public String getProject(String projectName) {
        String projectDetails = "Details of project: " + projectName;
        return projectDetails;
    }

    // Method to send project updates
    public void sendProjectUpdate(String projectUpdate) {
        template.convertAndSend("/api/Project", projectUpdate);
    }
}
