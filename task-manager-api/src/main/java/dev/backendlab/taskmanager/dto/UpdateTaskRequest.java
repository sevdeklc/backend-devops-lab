package dev.backendlab.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateTaskRequest(
        @NotBlank(message = "Title cannot be blank")
        @Size(max = 255, message = "Title cannot exceed 255 characters")
        String title,

        @Size(max = 1000, message = "Description cannot exceed 1000 characters")
        String description,

        boolean completed
) {
}