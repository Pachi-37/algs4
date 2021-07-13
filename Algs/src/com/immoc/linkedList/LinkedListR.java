package com.immoc.linkedList;

import javafx.util.Pair;

/**
 * @author pachi
 */
public class LinkedListR<E> {

    private class Node {

        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int index, E e) {

        if (index < 0 || index > getSize()) {
            throw new IllegalArgumentException("Add failed, Illegal index.");
        }

        head = add(head, index, e);
        size++;

    }

    private Node add(Node node, int index, E e) {

        if (index == 0) {
            return new Node(e, node);
        }

        node.next = add(node.next, index - 1, e);

        return node;
    }

    public void addFirst(E val) {
        add(0, val);
    }


    public void addLast(E val) {
        add(getSize() - 1, val);
    }

    public E get(int index) {

        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("Get failed, index illegal.");
        }

        return get(head, index);
    }

    private E get(Node node, int index) {

        if (index == 0) {
            return node.e;
        }

        return get(node.next, index - 1);
    }

    public E getFirst() {
        return get(head, 0);
    }

    public E getLast() {
        return get(head, getSize() - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("Set failed, illegal index.");
        }

        set(head, index, e);
    }

    private void set(Node node, int index, E e) {

        if (index == 0) {
            node.e = e;
            return;
        }
        set(node.next, index - 1, e);
    }

    public boolean contains(E e) {
        return contains(head, e);
    }

    private boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }

        if (node.e.equals(e)) {
            return true;
        }

        return contains(node.next, e);
    }

    public E removeElement(int index) {

        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("RemoveElement failed, illegal index.");
        }

        return removeElement(head, index - 1);
    }

    private E removeElement(Node node, int index) {

        if (index == 0) {
            size--;
            return node.e;
        }

        return removeElement(node.next, index - 1);
    }

    public E remove(int index) {

        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("Remove failed, illegal index");
        }

        Pair<Node, E> res = remove(head, index);
        size--;
        head = res.getKey();
        return res.getValue();
    }

    private Pair<Node, E> remove(Node node, int index) {

        if (index == 0) {
            return new Pair<>(node.next, node.e);
        }

        Pair<Node, E> res = remove(node.next, index - 1);
        node.next = res.getKey();

        return new Pair<>(node, res.getValue());
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(getSize() - 1);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }

    public static void main(String[] args) {

        LinkedListR<Integer> list = new LinkedListR<>();

        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
            System.out.println(list);
        }

        while (!list.isEmpty()) {
            System.out.println("removed " + list.removeLast());
            System.out.println(list);
        }
    }
}
