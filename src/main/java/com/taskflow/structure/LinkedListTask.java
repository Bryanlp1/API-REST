package com.taskflow.structure;

import com.taskflow.model.Task;
import java.util.ArrayList;
import java.util.List;

public class LinkedListTask {

    private class Node {
        Task data;
        Node next;

        Node(Task data) {
            this.data = data;
        }
    }

    private Node head;

    public void insert(Task task) {
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public List<Task> getAll() {
        List<Task> list = new ArrayList<>();
        Node current = head;

        while (current != null) {
            list.add(current.data);
            current = current.next;
        }

        return list;
    }

    public Task findById(String id) {
        Node current = head;

        while (current != null) {
            if (current.data.getId().equals(id)) {
                return current.data;
            }
            current = current.next;
        }

        return null;
    }

    public boolean deleteById(String id) {
        if (head == null) return false;

        if (head.data.getId().equals(id)) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.getId().equals(id)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }
}