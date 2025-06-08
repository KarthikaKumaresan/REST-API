package com.karthika.taskapi.controller;

import com.karthika.taskapi.model.Task;

import com.karthika.taskapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Optional;
import com.karthika.taskapi.model.TaskExecution;

import java.util.ArrayList;


import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable String id) {
        return taskRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @RequestBody Task updatedTask) {
        updatedTask.setId(id);
        return taskRepository.save(updatedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        taskRepository.deleteById(id);
    }
    @GetMapping("/search")
    public List<Task> findTasksByName(@RequestParam String name) {
        List<Task> tasks = taskRepository.findByNameContainingIgnoreCase(name);
        if (tasks.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No tasks found with name containing: " + name);
        }
        return tasks;
    }
    @PutMapping("/{id}/execute")
    public Task executeTask(@PathVariable String id) {
        // Find the task
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));

        Date startTime = new Date();

        try {
            // Run the shell command
        	Process process = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", task.getCommand()});
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            StringBuilder outputBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                outputBuilder.append(line).append("\n");
            }

            process.waitFor();

            Date endTime = new Date();

            // Create TaskExecution
            TaskExecution execution = new TaskExecution(startTime, endTime, outputBuilder.toString().trim());

            // Add execution to task
            if (task.getTaskExecutions() == null) {
                task.setTaskExecutions(new ArrayList<>());
            }
            task.getTaskExecutions().add(execution);

            // Save updated task
            return taskRepository.save(task);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Command execution failed", e);
        }
    }
}
