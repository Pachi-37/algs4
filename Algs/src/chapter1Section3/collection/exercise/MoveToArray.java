package chapter1Section3.collection.exercise;

import edu.princeton.cs.algs4.StdIn;

/**
 * @author pachi
 * @deprecated 从标准输入读取一串字符，使用链表保存这些字符并清除重复字符
 */
public class MoveToArray<Item> {
    private class Node {
        Node next;
        Item item;

        Node(Item item) {
            this.item = item;
            next = null;
        }

        Node(){}
    }

    private int cap = 0;
    private Node head;

    public void move(Item val) {
        Node current = head;

        for (int i = 0; i < cap; i++) {
            if (isRepeat(current.item,val)) {
                current = current.next;
                return;
            }
            current = current.next;
        }
        this.push(val);
    }

    public void showAll() {
        for (Node current = head; current != null; current = current.next)
            System.out.print(current.item + " ");
    }

    public void push(Item item) {
        Node oldFirst = head;
        head = new Node();
        head.item = item;
        head.next = oldFirst;
        cap++;
    }

    private int size(){
        return cap;
    }

    private boolean isRepeat(Item target, Item key){
        return target == key;
    }

    public static void main(String[] args) {
        MoveToArray<Character> moveToArray = new MoveToArray<>();

        while (!StdIn.isEmpty()){
            moveToArray.move(StdIn.readChar());
        }
        moveToArray.showAll();
    }
}
