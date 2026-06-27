package dev.backendlab.taskmanager.service;

import dev.backendlab.taskmanager.dto.CreateTaskRequest;
import dev.backendlab.taskmanager.dto.TaskResponse;
import dev.backendlab.taskmanager.dto.UpdateTaskRequest;

import java.util.List;

public interface TaskService {

    List<TaskResponse> getAllTasks();

    TaskResponse getTaskById(Long id);

    TaskResponse createTask(CreateTaskRequest request);

    TaskResponse updateTask(Long id, UpdateTaskRequest request);

    void deleteTask(Long id);
}