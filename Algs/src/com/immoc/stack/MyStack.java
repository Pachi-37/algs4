package com.immoc.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pachi
 */
public class MyStack <E>{

    private Queue<E> q;

    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(E e) {
        q.add(e);
    }

    /** Removes the element on top of the stack and returns that element. */
    public E pop() {
        Queue<E> q2 = new LinkedList<>();

        while (q.size() > 1){
            q2.add(q.remove());
        }

        E ret = q.remove();

        q = q2;

        return ret;
    }

    /** Get the top element. */
    public E top() {
        E ret = pop();

        push(ret);

        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
