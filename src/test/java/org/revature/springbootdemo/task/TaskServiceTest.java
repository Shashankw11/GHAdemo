package org.revature.springbootdemo.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.revature.springbootdemo.dao.TaskRepository;
import org.revature.springbootdemo.models.Task;
import org.revature.springbootdemo.services.TaskService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void testGetTaskById() {
        // Arrange
        long taskId = 1L;
        Task task = new Task(taskId, "Task 1", "Description 1", 1L);
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(task));

        // Act
        Optional<Task> result = taskService.getTaskById(taskId);

        // Assert
        assertEquals(Optional.of(task), result);
    }
}