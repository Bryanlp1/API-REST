package com.taskflow.controller;

import com.taskflow.model.Action;
import com.taskflow.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/undo")
public class UndoController {

    private final TaskService service;

    public UndoController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/peek")
    public ResponseEntity<Action> peek() {
        Action action = service.peekUndo();
        return (action != null)
                ? ResponseEntity.ok(action)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<Action> pop() {
        Action action = service.undo();
        return (action != null)
                ? ResponseEntity.ok(action)
                : ResponseEntity.notFound().build();
    }
}