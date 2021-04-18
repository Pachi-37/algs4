package chapter1Section3.collection.exercise;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author pachi
 * @deprecated 为 `Stack` 添加一个方法 `peek()`， 返回栈中最近添加的元素（不弹出它）
 */
public class Stack<Item>{
    public Stack() {

    }

    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private int stackSize;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return stackSize;
    }

    public void push(Item val) {
        Node oldFirst = first;
        first = new Node();
        first.item = val;
        stackSize++;
        first.next = oldFirst;
    }

    public Item pop() {
        Item item = first.item;
        Node newFirst = first.next;
        first = null;
        stackSize--;
        first = newFirst;
        return item;
    }

    private class StackIterator<Item> implements Iterator<Item> {
        private Node current = first;
        private int count = size();

        public boolean hasNext() {
            if (count != size()) {
                throw new ConcurrentModificationException("Stack was being modified");
            } else {
                return current != null;
            }
        }

        public Item next() {
            Item val;
            if (count != size()) {
                throw new ConcurrentModificationException("Stack was bing modified");
            }
               val = (Item) current.item;
                current = current.next;
                return val;
        }
    }
}
