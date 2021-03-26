package chapter1Section3.collection.exercise;

import java.util.Iterator;

/**
 * @author pachi
 * @deprecated 一个以栈为目标的队列（`steque`），是一种支持 `push` 、`pop` 和 `enqueue` 操作的数据类型。为了这种抽象数据类型定义一份 `API` 并给出一份基于链表的实现
 */
public class Steque<Item> implements Iterator<Item> {

    @Override
    public boolean hasNext() {
        return isEmpty();
    }

    @Override
    public Item next() {
        Item item = pop();
        push(item);
        return item;
    }

    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private Node last;
    private int nodeLength;

    public boolean isEmpty() {
        return nodeLength < 0;
    }

    public int size() {
        return nodeLength;
    }

    public void enqueue(Item item) {
        Node newLast = new Node();
        newLast.item = item;
        if (isEmpty()) {
            first = last;
            last.next = null;
        } else {
            last.next = newLast;
        }
        nodeLength++;
        newLast.next = null;
    }

    public Item pop() {
        Node tmp;
        Item item = null;
        tmp = first;
        if (isEmpty()) {
            first = last;
            last = null;
            throw new RuntimeException("The queue is empty.");
        } else {
            item = tmp.item;
            first = first.next;
            tmp.next = null;
        }
        nodeLength--;
        return item;
    }

    public void push(Item item) {
        Node newFirst = new Node();
        newFirst.item = item;
        if (isEmpty()) {
            first = last;
            last.next = null;
        } else {
            newFirst.next = first;
            first = newFirst;
        }
        nodeLength++;
    }
}
