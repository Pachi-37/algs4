package chapter1Section3.collection.exercise;

/**
 * @author pachi
 * @deprecated 为 `Stack` 添加一个方法 `peek()`， 返回栈中最近添加的元素（不弹出它）
 */
public class Stack<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private int stackSize;

    public boolean isEmpty() {
        return first == null;
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
}
