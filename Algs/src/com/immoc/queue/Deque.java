package com.immoc.queue;

/**
 * @author pachi
 */
public class Deque<E> {

    private E[] data;
    private int size;
    private int front, tail;

    public Deque(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
        front = 0;
        tail = 0;
    }

    public Deque() {
        this(10);
    }

    public void addFront(E e) {

        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }

        front = (front + data.length - 1) % data.length;
        data[front] = e;
        size++;
    }

    public void addLast(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public E removeFront() {


        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }

    public E removeLast() {

        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        tail = (tail + data.length - 1) % data.length;
        E ret = data[tail];
        data[tail] = null;
        size--;

        if (getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        return data[front];
    }

    public E getLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        int index = (tail + data.length - 1) % data.length;

        return data[index];
    }

    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = getSize();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        for (int i = 0; i < size; i++) {
            res.append(data[(i + front) % data.length]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        // 在下面的双端队列的测试中，偶数从队尾加入；奇数从队首加入
        Deque<Integer> dq = new Deque<>();
        for (int i = 0; i < 16; i++) {
            if (i % 2 == 0) dq.addLast(i);
            else dq.addFront(i);
            System.out.println(dq);
        }

        // 之后，我们依次从队首和队尾轮流删除元素
        System.out.println();
        for (int i = 0; !dq.isEmpty(); i++) {
            if (i % 2 == 0) dq.removeFront();
            else dq.removeLast();
            System.out.println(dq);
        }
    }
}
