package com.taskflow.structure;

import com.taskflow.model.Task;

public class QueueTask {

    private class Node {
        Task data;
        Node next;

        Node(Task data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;

    public void enqueue(Task task) {
        Node newNode = new Node(task);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public Task dequeue() {
        if (front == null) return null;

        Task task = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return task;
    }

    public Task peek() {
        return (front != null) ? front.data : null;
    }
}