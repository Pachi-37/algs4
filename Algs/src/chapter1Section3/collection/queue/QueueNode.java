package chapter1Section3.collection.queue;

import java.util.Iterator;

/**
 * @author pachi
 * @deprecated 使用链表来实现队列
 */
public class QueueNode<Item> implements Iterator<Item> {
    @Override
    public boolean hasNext() {
        return queueLength > 0;
    }

    @Override
    public Item next() {
        return first.item;
    }

    private class Node {
        Item item;
        Node next;
    }

    private int queueLength;
    Node first;
    Node last;

    public boolean isEmpty() {
        return first.next == null;
    }

    public int size() {
        return queueLength;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        queueLength++;
    }

    public Item dequeue() {
        Item item = first.item;
        Node newFirst = first.next;
        first.next = null;
        first = newFirst;
        if (isEmpty()) {
            last = null;
        }
        queueLength--;
        return item;
    }
}
