package com.taskflow.repository;

import com.taskflow.model.Task;
import com.taskflow.structure.QueueTask;
import org.springframework.stereotype.Repository;

@Repository
public class QueueRepository {

    private QueueTask queue = new QueueTask();

    public void enqueue(Task task) {
        queue.enqueue(task);
    }

    public Task dequeue() {
        return queue.dequeue();
    }

    public Task peek() {
        return queue.peek();
    }
}