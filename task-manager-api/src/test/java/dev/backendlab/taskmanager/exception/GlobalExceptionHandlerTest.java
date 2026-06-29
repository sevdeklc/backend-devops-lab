package dev.backendlab.taskmanager.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.backendlab.taskmanager.controller.TaskController;
import dev.backendlab.taskmanager.service.TaskService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
@Import(GlobalExceptionHandler.class)
public class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private TaskService taskService;

    @Test
    @DisplayName("Should return 404 when task does not exist")
    void should_Return404_When_TaskDoesNotExist() throws Exception {

        when(taskService.getTaskById(999L))
                .thenThrow(new TaskNotFoundException(999L));

        mockMvc.perform(get("/tasks/999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.error").value("Not Found"))
                .andExpect(jsonPath("$.message")
                        .value("Task with id 999 not found"))
                .andExpect(jsonPath("$.fieldErrors").doesNotExist());
    }
}
