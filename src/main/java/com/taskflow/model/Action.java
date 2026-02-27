package com.taskflow.model;

import java.time.LocalDateTime;

public class Action {

    private String description;
    private LocalDateTime createdAt;

    public Action(String description) {
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }

    public String getDescription() { return description; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}