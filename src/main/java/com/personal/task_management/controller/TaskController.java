package com.personal.task_management.controller;

import com.personal.task_management.model.Task;
import com.personal.task_management.response.ApiResponse;
import com.personal.task_management.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // @description get all task
    // @route /api/tasks
    // @method GET
    @GetMapping
    public ResponseEntity<ApiResponse> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        ApiResponse response = new ApiResponse("All tasks fetched successfully", true, tasks);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // @description get task by id
    // @route /api/tasks/{id}
    // @method GET
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        ApiResponse response;

        if (task == null) {
            response = new ApiResponse("Task not found", false);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response = new ApiResponse("Task fetched successfully", true, List.of(task));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // @description create task
    // @route /api/tasks
    // @method POST
    @PostMapping
    public ResponseEntity<ApiResponse> createTask(@RequestBody Task task) {
        taskService.createTask(task);
        ApiResponse response = new ApiResponse("Task created successfully", true);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // @description update task
    // @route /api/tasks/{id}
    // @method PUT
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateTask(@PathVariable Long id, @RequestBody Task task) {
        ApiResponse response;

        // Check if the task exists
        Task existingTask = taskService.getTaskById(id);
        if (existingTask == null) {
            response = new ApiResponse("Task not found", false);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        // Perform the update
        Task updatedTask = taskService.updateTask(id, task);
        if (updatedTask != null) {
            response = new ApiResponse("Task updated successfully", true, List.of(updatedTask));
        } else {
            response = new ApiResponse("Failed to update task", false);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // @description delete task
    // @route /api/tasks/{id}
    // @method DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteTask(@PathVariable Long id) {
        ApiResponse response;
        // if task does not exist send response as task does not exist
        if (taskService.getTaskById(id) == null) {
            response = new ApiResponse("Task not found", false);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        taskService.deleteTask(id);
        response = new ApiResponse("Task deleted successfully", true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
