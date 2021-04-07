package chapter1Section3.collection.exercise;

import edu.princeton.cs.algs4.StdIn;

/**
 * @author pachi
 * @deprecated 从标准输入读取一串字符，使用链表保存并清除重复的字符。读取一个元素插入表头（如果重复先删除再插入）
 */
public class MoveToFront<Item> {
    private class Node {
        Item item;
        Node next;

        Node(Item item) {
            this.item = item;
            this.next = null;
        }

        Node() {
        }
    }

    public Node head;
    private int cap;

    public void insert(Item val) {
        Node node = new Node(val);

        if(head!=null && head.item == val) return;

        Node cur = head;
        for (; cur != null && cur.next != null; cur = cur.next) {
            if (isRepeat(cur.next.item, val)) {
                Node temp = cur.next;
                cur.next = cur.next.next;
                temp.next = null;
                break;
            }
        }
        node.next = head;
        head = node;
    }

    public int size() {
        return cap;
    }

    public boolean isEmpty() {
        return cap == 0;
    }

    public boolean isRepeat(Item target, Item val) {
        return val.equals(target);
    }

    public void showAll(){
        int len = size();
        Node cur = head;

        for (int i = 0; i < len; i++) {
            System.out.println(head.item);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        String string = StdIn.readString();
        char[] tmp = string.toCharArray();

        MoveToFront<Character> moveToFront = new MoveToFront<>();

        for (int i = 0; i < tmp.length; i++) {
            moveToFront.insert(tmp[i]);
        }

        moveToFront.showAll();
    }
}
