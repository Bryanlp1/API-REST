package com.taskflow.structure;

import com.taskflow.model.Action;

public class StackAction {

    private class Node {
        Action data;
        Node next;

        Node(Action data) {
            this.data = data;
        }
    }

    private Node top;

    public void push(Action action) {
        Node newNode = new Node(action);
        newNode.next = top;
        top = newNode;
    }

    public Action pop() {
        if (top == null) return null;

        Action action = top.data;
        top = top.next;
        return action;
    }

    public Action peek() {
        return (top != null) ? top.data : null;
    }
}