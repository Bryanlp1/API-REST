package com.taskflow.service;

import com.taskflow.model.Action;
import com.taskflow.model.Task;
import com.taskflow.repository.QueueRepository;
import com.taskflow.repository.TaskRepository;
import com.taskflow.repository.UndoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UndoRepository undoRepository;
    private final QueueRepository queueRepository;

    public TaskService(TaskRepository taskRepository,
                       UndoRepository undoRepository,
                       QueueRepository queueRepository) {
        this.taskRepository = taskRepository;
        this.undoRepository = undoRepository;
        this.queueRepository = queueRepository;
    }

    public Task createTask(String title) {
        Task task = new Task(title);
        taskRepository.save(task);
        undoRepository.push(new Action("Created task: " + title));
        return task;
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(String id) {
        return taskRepository.findById(id);
    }

    public boolean delete(String id) {
        Task task = taskRepository.findById(id);
        if (task == null) return false;

        taskRepository.deleteById(id);
        undoRepository.push(new Action("Deleted task: " + task.getTitle()));
        return true;
    }

    public void enqueue(String id) {
        Task task = taskRepository.findById(id);
        if (task != null) {
            queueRepository.enqueue(task);
        }
    }

    public Task dequeue() {
        return queueRepository.dequeue();
    }

    public Task peekQueue() {
        return queueRepository.peek();
    }

    public Action undo() {
        return undoRepository.pop();
    }

    public Action peekUndo() {
        return undoRepository.peek();
    }
}