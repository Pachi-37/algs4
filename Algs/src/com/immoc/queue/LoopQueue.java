package com.immoc.queue;

/**
 * @author pachi
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {

        if (isFull()) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {

        if (isEmpty()) {
            throw new IllegalArgumentException("Can not dequeue from a empty queue.");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }

    @Override
    public E getFront() {

        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        return data[front];
    }

    @Override
    public boolean isEmpty() {
        if (tail == front) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isFull() {

        if ((tail + 1) % data.length == front) {
            return true;
        }

        return false;
    }


    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity + 1];

        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(i + front) % data.length];
        }
        front = 0;
        tail = size;
        data = newData;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d.\n",size,getCapacity()));
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

        LoopQueue<Integer> queue = new LoopQueue<>();

        for (int i = 0; i < 21; i++) {
            queue.enqueue(i);
        }

        System.out.println(queue.toString());
    }
}
