package com.personal.task_management.repository;

import com.personal.task_management.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // You can add custom query methods here if needed
}
