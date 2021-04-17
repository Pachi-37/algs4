package chapter1Section3.collection.exercise;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @author pachi
 * @deprecated 编写一个使用双向链表实现 `Deque` 类，以及使用动态数组调整实现的 `ResizingArrayDeque` 1.3.46双向队列与栈
 */
public class Deque<Item> implements Iterator<Item> {

    private class Node {
        Item item;
        Node prev;
        Node next;

        Node(){
            prev = null;
            next = null;
        }
    }

    private Node right;
    private Node left;
    private int dequeLength;

    public Deque() {

    }

    public boolean isEmpty() {
        return dequeLength == 0;
    }

    public int size() {
        return dequeLength;
    }

    public void pushLeft(Item item) {
        Node newLeft = new Node();
        newLeft.item = item;
        if (isEmpty()) {
            left = newLeft;
            right = left;
        } else {
            newLeft.next = left;
            left = newLeft;
        }
        dequeLength++;
    }

    public void pushRight(Item item) {
        Node newRight = new Node();
        newRight.item = item;
        if (isEmpty()) {
            right = newRight;
            left = right;
        } else {
            newRight.prev = right;
            right = newRight;
        }
        dequeLength++;
    }

    public Item getRight() {
        Item item;
        if (isEmpty()) {
            right = left;
            throw new RuntimeException("The dequeue is empty");
        }
        item = right.item;
        return item;
    }

    public Item popLeft() {
        Item item;
        if (isEmpty()) {
            right = left;
            right.next = null;
            left.prev = null;
            throw new RuntimeException("The dequeue is empty");
        }
        item = left.item;
        left = left.next;
        dequeLength--;
        return item;
    }

    public Item popRight() {
        Item item;
        if (isEmpty()) {
            right = left;
        }
        right = right.prev;
        item = right.item;
        dequeLength--;
        return item;
    }


    @Override
    public boolean hasNext() {
        return dequeLength > 0;
    }

    @Override
    public Item next() {
        return getRight();
    }

    public static void main(String[] args) {
        Deque<Integer> twoStackWithQueue = new Deque<>();

        for (int i = 0; i < 3; i++) {
            twoStackWithQueue.pushRight(i);
        }

        StdOut.println(twoStackWithQueue.popRight());
        for (int i = 0; i < 5; i++) {
            twoStackWithQueue.pushLeft(i);
        }
    }
}
