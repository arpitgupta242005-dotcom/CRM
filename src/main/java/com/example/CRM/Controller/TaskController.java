package com.example.CRM.Controller;

import com.example.CRM.Entity.Task;
import com.example.CRM.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @GetMapping("/{id}")
    public ResponseEntity<Task> getAllById(@PathVariable Long id){
        return ResponseEntity.ok(taskService.getTaskById(id));
    }
    @GetMapping
    public ResponseEntity<Page<Task>> getAllTasks(Pageable pageable){
        return ResponseEntity.ok(taskService.getAllTasks(pageable));
    }
    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.addTask(task));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok("deleted");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTask(id, task));
    }
}
