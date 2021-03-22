package chapter1Section3.collection.exercise.link;

public class Link<Item> {
    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private Node last;
    private int nodeLength;

    public boolean isEmpty() {
        return first.next == null;
    }

    public int size() {
        return nodeLength;
    }

    public int size(Node node) {
        int length = 0;
        while (node.next != null) {
            length++;
        }
        return length;
    }

    public void add(Item item) {
        Node old = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            old.next = last;
        }
    }

    public Item removeLast() {
        Item item;
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        } else {
            item = last.item;
        }

        Node tmp = first;
        Node cur = first;

        while (tmp.next != null) {
            cur = tmp;
            tmp = tmp.next;
        }

        cur.next = null;
        last = cur;
        nodeLength--;

        return item;
    }

    /**
     * 删除指定链表元素并返回值
     *
     * @param index 元素索引
     * @return 删除元素值
     */
    public Item delete(int index) {
        Item item;
        if (index > size() || index < 0) {
            throw new RuntimeException("索引不存在");
        }

        Node cur = first;
        Node tmp = first;
        while (tmp.next != null && index-- > 1) {
            cur = tmp;
            tmp = tmp.next;
        }

        item = cur.item;
        cur.next = tmp.next;
        nodeLength--;
        return item;
    }

    /**
     * 接收一条链表和一个字符串作为参数，是否存在元素
     *
     * @param node 链表
     * @param key  索引
     * @return 是否存在
     */
    public boolean find(Node node, int key) {
        return key <= size(node) && key >= 0;
    }

    /**
     * 删除该结点之后的元素
     *
     * @param node 结点索引
     */
    public void removeAfter(Node node) {
        if (node.next != null) {
            node.next = null;
        }
    }

    /**
     * 将第二个结点插入到第一个之后
     *
     * @param first 第一个结点
     * @param last  第二个结点
     */
    public void insertAfter(Node first, Node last) {
        Node tmp = first.next;
        first.next = last;
        last.next = tmp;
    }

    /**
     * 删除链表所有 `item` 域为 `key` 的结点
     *
     * @param node 目标链表
     * @param key  值
     */
    public void remove(Node node, String key) {
        Node tmp;
        while (node.next != null) {
            tmp = node;
            node = node.next;
            if (key.equals(tmp.item + "")) {
                tmp.next = node.next;
            }
        }
    }
}