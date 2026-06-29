package dev.backendlab.taskmanager.service;

import dev.backendlab.taskmanager.dto.CreateTaskRequest;
import dev.backendlab.taskmanager.dto.TaskResponse;
import dev.backendlab.taskmanager.dto.UpdateTaskRequest;
import dev.backendlab.taskmanager.entity.Task;
import dev.backendlab.taskmanager.exception.TaskNotFoundException;
import dev.backendlab.taskmanager.repository.TaskRepository;
import dev.backendlab.taskmanager.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @Test
    void getAllTasks_ShouldReturnTaskList() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Learn Unit Testing");
        task.setDescription("Write service tests");
        task.setCompleted(false);

        when(taskRepository.findAll()).thenReturn(List.of(task));

        List<TaskResponse> result = taskService.getAllTasks();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).id()).isEqualTo(1L);
        assertThat(result.get(0).title()).isEqualTo("Learn Unit Testing");
        assertThat(result.get(0).description()).isEqualTo("Write service tests");
        assertThat(result.get(0).completed()).isFalse();

        verify(taskRepository).findAll();
    }

    @Test
    void getTaskById_WhenTaskExists_ShouldReturnTask() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Learn Docker");
        task.setDescription("Docker basics");
        task.setCompleted(false);

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        TaskResponse result = taskService.getTaskById(1L);

        assertThat(result.id()).isEqualTo(1L);
        assertThat(result.title()).isEqualTo("Learn Docker");
        assertThat(result.description()).isEqualTo("Docker basics");
        assertThat(result.completed()).isFalse();

        verify(taskRepository).findById(1L);
    }

    @Test
    void getTaskById_WhenTaskDoesNotExist_ShouldThrowException() {
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> taskService.getTaskById(1L))
                .isInstanceOf(TaskNotFoundException.class);

        verify(taskRepository).findById(1L);
    }

    @Test
    void createTask_ShouldSaveAndReturnTask() {
        CreateTaskRequest request = new CreateTaskRequest(
                "Learn Mockito",
                "Mock repository behavior"
        );

        Task savedTask = new Task();
        savedTask.setId(1L);
        savedTask.setTitle("Learn Mockito");
        savedTask.setDescription("Mock repository behavior");
        savedTask.setCompleted(false);

        when(taskRepository.save(any(Task.class))).thenReturn(savedTask);

        TaskResponse result = taskService.createTask(request);

        assertThat(result.id()).isEqualTo(1L);
        assertThat(result.title()).isEqualTo("Learn Mockito");
        assertThat(result.description()).isEqualTo("Mock repository behavior");
        assertThat(result.completed()).isFalse();

        verify(taskRepository).save(any(Task.class));
    }

    @Test
    void updateTask_WhenTaskExists_ShouldUpdateAndReturnTask() {
        UpdateTaskRequest request = new UpdateTaskRequest(
                "Updated title",
                "Updated description",
                true
        );

        Task existingTask = new Task();
        existingTask.setId(1L);
        existingTask.setTitle("Old title");
        existingTask.setDescription("Old description");
        existingTask.setCompleted(false);

        Task updatedTask = new Task();
        updatedTask.setId(1L);
        updatedTask.setTitle("Updated title");
        updatedTask.setDescription("Updated description");
        updatedTask.setCompleted(true);

        when(taskRepository.findById(1L)).thenReturn(Optional.of(existingTask));
        when(taskRepository.save(existingTask)).thenReturn(updatedTask);

        TaskResponse result = taskService.updateTask(1L, request);

        assertThat(result.id()).isEqualTo(1L);
        assertThat(result.title()).isEqualTo("Updated title");
        assertThat(result.description()).isEqualTo("Updated description");
        assertThat(result.completed()).isTrue();

        verify(taskRepository).findById(1L);
        verify(taskRepository).save(existingTask);
    }

    @Test
    void updateTask_WhenTaskDoesNotExist_ShouldThrowException() {
        UpdateTaskRequest request = new UpdateTaskRequest(
                "Updated title",
                "Updated description",
                true
        );

        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> taskService.updateTask(1L, request))
                .isInstanceOf(TaskNotFoundException.class);

        verify(taskRepository).findById(1L);
        verify(taskRepository, never()).save(any(Task.class));
    }

    @Test
    void deleteTask_WhenTaskExists_ShouldDeleteTask() {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("Task to delete");

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        taskService.deleteTask(1L);

        verify(taskRepository).findById(1L);
        verify(taskRepository).delete(task);
    }

    @Test
    void deleteTask_WhenTaskDoesNotExist_ShouldThrowException() {
        when(taskRepository.findById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> taskService.deleteTask(1L))
                .isInstanceOf(TaskNotFoundException.class);

        verify(taskRepository).findById(1L);
        verify(taskRepository, never()).delete(any(Task.class));
    }
}
