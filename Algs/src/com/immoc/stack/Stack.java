package com.immoc.stack;

/**
 * 栈基础操作
 * @author pachi
 */
public interface Stack<E> {

    void push(E val);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
