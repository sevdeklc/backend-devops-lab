package dev.backendlab.taskmanager.controller;

import dev.backendlab.taskmanager.dto.CreateTaskRequest;
import dev.backendlab.taskmanager.dto.TaskResponse;
import dev.backendlab.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse createTask(
            @Valid @RequestBody CreateTaskRequest request
    ) {

        return taskService.createTask(request);

    }
}
