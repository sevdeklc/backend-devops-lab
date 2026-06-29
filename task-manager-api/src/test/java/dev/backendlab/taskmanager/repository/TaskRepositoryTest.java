package dev.backendlab.taskmanager.repository;

import dev.backendlab.taskmanager.entity.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    @DisplayName("Should save task successfully")
    void should_SaveTask_When_TaskIsValid() {
        Task task = new Task();
        task.setTitle("Learn DataJpaTest");
        task.setDescription("Repository test with H2");
        task.setCompleted(false);

        Task savedTask = taskRepository.save(task);

        assertThat(savedTask.getId()).isNotNull();
        assertThat(savedTask.getTitle()).isEqualTo("Learn DataJpaTest");
        assertThat(savedTask.getDescription()).isEqualTo("Repository test with H2");
        assertThat(savedTask.isCompleted()).isFalse();
    }

    @Test
    @DisplayName("Should find task by id")
    void should_FindTaskById_When_TaskExists() {
        Task task = new Task();
        task.setTitle("Find task");
        task.setDescription("Find by id test");
        task.setCompleted(false);

        Task savedTask = taskRepository.save(task);

        Optional<Task> foundTask = taskRepository.findById(savedTask.getId());

        assertThat(foundTask).isPresent();
        assertThat(foundTask.get().getTitle()).isEqualTo("Find task");
        assertThat(foundTask.get().getDescription()).isEqualTo("Find by id test");
    }

    @Test
    @DisplayName("Should return all tasks")
    void should_ReturnAllTasks_When_TasksExist() {
        Task task1 = new Task();
        task1.setTitle("Task 1");
        task1.setDescription("Description 1");
        task1.setCompleted(false);

        Task task2 = new Task();
        task2.setTitle("Task 2");
        task2.setDescription("Description 2");
        task2.setCompleted(true);

        taskRepository.save(task1);
        taskRepository.save(task2);

        List<Task> tasks = taskRepository.findAll();

        assertThat(tasks).hasSize(2);
    }

    @Test
    @DisplayName("Should delete task")
    void should_DeleteTask_When_TaskExists() {
        Task task = new Task();
        task.setTitle("Delete task");
        task.setDescription("Delete test");
        task.setCompleted(false);

        Task savedTask = taskRepository.save(task);

        taskRepository.delete(savedTask);

        Optional<Task> deletedTask = taskRepository.findById(savedTask.getId());

        assertThat(deletedTask).isEmpty();
    }
}
