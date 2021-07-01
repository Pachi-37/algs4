package com.immoc.queue;

import java.util.Stack;

/**
 * @author pachi
 */
public class MyQueue<E> {

    private Stack<E> s;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        s = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(E e) {

        Stack<E> tmp = new Stack<>();

        while (!s.isEmpty()){
            tmp.push(s.pop());
        }

        s.push(e);

        while (!tmp.isEmpty()){
            s.push(tmp.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public E pop() {
        return s.pop();
    }

    /**
     * Get the front element.
     */
    public E peek() {
       return s.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s.isEmpty();
    }
}
