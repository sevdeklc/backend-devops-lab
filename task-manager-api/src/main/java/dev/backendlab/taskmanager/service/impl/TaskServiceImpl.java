package dev.backendlab.taskmanager.service.impl;

import dev.backendlab.taskmanager.dto.CreateTaskRequest;
import dev.backendlab.taskmanager.dto.TaskResponse;
import dev.backendlab.taskmanager.dto.UpdateTaskRequest;
import dev.backendlab.taskmanager.entity.Task;
import dev.backendlab.taskmanager.mapper.TaskMapper;
import dev.backendlab.taskmanager.repository.TaskRepository;
import dev.backendlab.taskmanager.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskResponse> getAllTasks() {
        return null;
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        return null;
    }

    @Override
    public TaskResponse createTask(CreateTaskRequest request) {
        Task task = new Task();

        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setCompleted(false);

        Task savedTask = taskRepository.save(task);

        return TaskMapper.toResponse(savedTask);
    }

    @Override
    public TaskResponse updateTask(Long id, UpdateTaskRequest request) {
        return null;
    }

    @Override
    public void deleteTask(Long id) {

    }
}