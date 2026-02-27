package com.taskflow.repository;

import com.taskflow.model.Task;
import com.taskflow.structure.LinkedListTask;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {

    private LinkedListTask list = new LinkedListTask();

    public void save(Task task) {
        list.insert(task);
    }

    public List<Task> findAll() {
        return list.getAll();
    }

    public Task findById(String id) {
        return list.findById(id);
    }

    public boolean deleteById(String id) {
        return list.deleteById(id);
    }
}