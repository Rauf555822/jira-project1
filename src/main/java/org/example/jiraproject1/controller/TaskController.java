package org.example.jiraproject1.controller;

import lombok.RequiredArgsConstructor;
import org.example.jiraproject1.model.Task;
import org.example.jiraproject1.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/getAll")
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @PostMapping("/create") // yeni task yaratmaq ve save etmek
    public Task create(@RequestBody Task task) {
        return taskService.createtask(task);
    }

    @PutMapping("/update/{id}")
    public Task update(@PathVariable String id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @GetMapping("getById/{id}")
    public Task getTaskById(@PathVariable String id) {
        return taskService.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteTask(@PathVariable String id) {
        return taskService.deleteTask(id);

    }


}