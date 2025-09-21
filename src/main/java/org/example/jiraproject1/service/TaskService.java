
package org.example.jiraproject1.service;

import lombok.RequiredArgsConstructor;
import org.example.jiraproject1.model.Task;
import org.example.jiraproject1.repository.TaskRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;


    public List<Task> getAll() {
        return taskRepository.findAll();
    }


    public Task createtask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(String id, @NotNull Task taskDetails) {
        Task existing = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id - " + id));
        existing.setTitle(taskDetails.getTitle());
        existing.setStatus(taskDetails.getStatus());
        existing.setDescription(taskDetails.getDescription());
        existing.setDueDate(taskDetails.getDueDate());
        return taskRepository.save(existing);

    }

    public Task findById(String id) {
        return taskRepository.findById(id).orElse(null);
    }

    public String deleteTask(String id) {
        Optional<Task> existing = taskRepository.findById(id);

        if (existing.isPresent()) {
            taskRepository.deleteById(id);
            return "Task :" + id + " deleted successfully.";
        }else {
            return "Task :" + id + " not found.";
        }
    }
}
