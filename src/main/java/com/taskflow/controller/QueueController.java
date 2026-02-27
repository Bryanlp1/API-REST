package com.taskflow.controller;

import com.taskflow.model.Task;
import com.taskflow.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/queue")
public class QueueController {

    private final TaskService service;

    public QueueController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> enqueue(@RequestBody Map<String,String> body) {
        if (!body.containsKey("taskId"))
            return ResponseEntity.badRequest().build();

        service.enqueue(body.get("taskId"));
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/next")
    public ResponseEntity<Task> peek() {
        Task task = service.peekQueue();
        return (task != null)
                ? ResponseEntity.ok(task)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<Task> dequeue() {
        Task task = service.dequeue();
        return (task != null)
                ? ResponseEntity.ok(task)
                : ResponseEntity.notFound().build();
    }
}