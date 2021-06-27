package com.immoc.stack;

import com.immoc.array.Array;

/**
 * 基于动态数组实现栈
 *
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> data;

    public ArrayStack(int capacity) {
        data = new Array<>(capacity);
    }

    public ArrayStack(){}

    public int getCapacity(){
        return data.getCapacity();
    }

    @Override
    public void push(E val) {
        data.addFirst(val);
    }

    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public E peek() {
        return data.get(0);
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("top [");
        for (int i = 0; i < getSize(); i++) {
            res.append(data.get(i));
            if (i != data.getSize() - 1){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(12);
        for (int i = 0; i < 10; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack.toString());
    }
}
