package com.personal.task_management.response;
import java.util.List;
import com.personal.task_management.model.Task;

public class ApiResponse {
    private String message;
    private boolean success;
    private List<Task> tasks; 

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public ApiResponse(String message, boolean success, List<Task> tasks) {
        this.message = message;
        this.success = success;
        this.tasks = tasks; 
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Task> getTasks() {
        return tasks; 
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks; 
    }
}
