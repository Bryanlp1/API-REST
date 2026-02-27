package com.taskflow.repository;

import com.taskflow.model.Action;
import com.taskflow.structure.StackAction;
import org.springframework.stereotype.Repository;

@Repository
public class UndoRepository {

    private StackAction stack = new StackAction();

    public void push(Action action) {
        stack.push(action);
    }

    public Action pop() {
        return stack.pop();
    }

    public Action peek() {
        return stack.peek();
    }
}