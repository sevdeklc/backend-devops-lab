package dev.backendlab.taskmanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.backendlab.taskmanager.dto.CreateTaskRequest;
import dev.backendlab.taskmanager.dto.TaskResponse;
import dev.backendlab.taskmanager.dto.UpdateTaskRequest;
import dev.backendlab.taskmanager.service.TaskService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private TaskService taskService;

    @Test
    @DisplayName("GET /tasks should return all tasks")
    void should_ReturnAllTasks_When_GetAllTasksEndpointIsCalled() throws Exception {
        TaskResponse task = new TaskResponse(
                1L,
                "Learn Docker",
                "Docker basics",
                false,
                null,
                null
        );

        when(taskService.getAllTasks()).thenReturn(List.of(task));

        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].title").value("Learn Docker"))
                .andExpect(jsonPath("$[0].description").value("Docker basics"))
                .andExpect(jsonPath("$[0].completed").value(false));

        verify(taskService).getAllTasks();
    }

    @Test
    @DisplayName("GET /tasks/{id} should return task by id")
    void should_ReturnTask_When_TaskExists() throws Exception {
        TaskResponse task = new TaskResponse(
                1L,
                "Learn Testing",
                "Controller test",
                false,
                null,
                null
        );

        when(taskService.getTaskById(1L)).thenReturn(task);

        mockMvc.perform(get("/tasks/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Learn Testing"))
                .andExpect(jsonPath("$.description").value("Controller test"))
                .andExpect(jsonPath("$.completed").value(false));

        verify(taskService).getTaskById(1L);
    }

    @Test
    @DisplayName("POST /tasks should create task")
    void should_CreateTask_When_RequestIsValid() throws Exception {
        CreateTaskRequest request = new CreateTaskRequest(
                "Learn MockMvc",
                "Write controller tests"
        );

        TaskResponse response = new TaskResponse(
                1L,
                "Learn MockMvc",
                "Write controller tests",
                false,
                null,
                null
        );

        when(taskService.createTask(any(CreateTaskRequest.class))).thenReturn(response);

        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Learn MockMvc"))
                .andExpect(jsonPath("$.description").value("Write controller tests"))
                .andExpect(jsonPath("$.completed").value(false));

        verify(taskService).createTask(any(CreateTaskRequest.class));
    }

    @Test
    @DisplayName("POST /tasks should return 400 when title is blank")
    void should_ReturnBadRequest_When_CreateTaskTitleIsBlank() throws Exception {
        CreateTaskRequest request = new CreateTaskRequest(
                "",
                "Description"
        );

        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());

        verify(taskService, never()).createTask(any(CreateTaskRequest.class));
    }

    @Test
    @DisplayName("PUT /tasks/{id} should update task")
    void should_UpdateTask_When_RequestIsValid() throws Exception {
        UpdateTaskRequest request = new UpdateTaskRequest(
                "Updated title",
                "Updated description",
                true
        );

        TaskResponse response = new TaskResponse(
                1L,
                "Updated title",
                "Updated description",
                true,
                null,
                null
        );

        when(taskService.updateTask(eq(1L), any(UpdateTaskRequest.class))).thenReturn(response);

        mockMvc.perform(put("/tasks/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Updated title"))
                .andExpect(jsonPath("$.description").value("Updated description"))
                .andExpect(jsonPath("$.completed").value(true));

        verify(taskService).updateTask(eq(1L), any(UpdateTaskRequest.class));
    }

    @Test
    @DisplayName("DELETE /tasks/{id} should delete task")
    void should_DeleteTask_When_TaskExists() throws Exception {
        doNothing().when(taskService).deleteTask(1L);

        mockMvc.perform(delete("/tasks/{id}", 1L))
                .andExpect(status().isNoContent());

        verify(taskService).deleteTask(1L);
    }
}
