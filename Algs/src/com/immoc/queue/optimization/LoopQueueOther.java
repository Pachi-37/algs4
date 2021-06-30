package com.immoc.queue.optimization;

import com.immoc.queue.Queue;

/**
 * 使用额外空间替换 `size` 变量
 *
 * @param <E>
 * @author pachi
 */
public class LoopQueueOther<E> implements Queue<E> {

    private E[] data;
    private int front, tail;

    public LoopQueueOther(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueueOther() {
        this(10);
    }

    @Override
    public void enqueue(E e) {

        if ((tail + 1) % data.length == front) {
            resize(data.length * 2 - 1);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue() {

        E ret = data[front];

        if (isEmpty()) {
            throw new IllegalArgumentException("Can not dequeue from empty queue");
        }

        data[front] = null;
        front = (front + 1) % data.length;

        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getSize() * 2 + 1);
        }

        return ret;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public int getSize() {
        return tail >= front ? tail - front : tail - front + data.length;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; (i + front) % data.length != tail; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        front = 0;
        tail = getSize();
        data = newData;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d.\n", getSize(), getCapacity()));
        res.append("front [");

        for (int i = front; i != tail; i = (i + 1) % data.length) {

            res.append(data[i]);

            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }

        res.append("] tail");

        return res.toString();
    }

    public static void main(String[] args) {

        LoopQueueOther<Integer> queue = new LoopQueueOther<>();

        for (int i = 0; i < 21; i++) {
            queue.enqueue(i);
        }

        System.out.println(queue.toString());
    }
}
