package dev.backendlab.taskmanager.mapper;

import dev.backendlab.taskmanager.dto.TaskResponse;
import dev.backendlab.taskmanager.entity.Task;

public class TaskMapper {

    private TaskMapper() {
    }

    public static TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }
}
