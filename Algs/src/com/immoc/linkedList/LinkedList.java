package com.immoc.linkedList;

/**
 * @author pachi
 */
public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {

        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获得链表的长度
     *
     * @return 长度
     */
    public int getSize() {
        return size;
    }

    /**
     * 链表是否为空
     *
     * @return 空 真
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向链表索引位置添加元素
     *
     * @param index 索引
     * @param e     元素
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, require index >= 0 and index <= size.");
        }

        Node pre = dummyHead;

        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = new Node(e, pre.next);
        size++;
    }

    /**
     * 向链表尾添加元素
     *
     * @param e 元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向链表头添加元素
     *
     * @param e 元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 返回指定索引的值
     *
     * @param index 索引
     * @return 索引处值
     */
    public E get(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get value failed, index illegal.");
        }

        Node cur = dummyHead.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    /**
     * 获取第一个元素的值
     *
     * @return 第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取最后一个元素的值
     *
     * @return 末尾元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 设置索引为 index 元素值
     *
     * @param index 索引
     * @param val   更改元素
     */
    public void set(int index, E val) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get value failed, index illegal.");
        }

        Node cur = dummyHead.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.e = val;
    }

    /**
     * 判断链表中是否含有元素 val
     *
     * @param val 待查找元素
     * @return 存在 真
     */
    public boolean contains(E val) {

        if (isEmpty()) {
            return false;
        }

        Node cur = dummyHead.next;

        for (int i = 0; i < size; i++) {

            if (cur.e.equals(val)) {
                return true;
            }

            cur = cur.next;
        }

        return false;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        res.append("Head ");

        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
           res.append(cur).append(" -> ");
        }
        res.append("NULL");

        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
    }
}
