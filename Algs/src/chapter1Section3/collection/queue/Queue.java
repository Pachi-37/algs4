package chapter1Section3.collection.queue;

import java.util.Iterator;

/**
 * @author pachi
 */
public class Queue<Item> implements Iterator<Item> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Item next() {
        return null;
    }

    private class Node{
        Item item;
        Node next;
    }

    private Node first;
    private Node last;
    private int queueLength;

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return queueLength;
    }

    public void enqueue(Item val){
       Node oldLast = last;
       last = new Node();
       last.next = null;
       last.item = val;
       if(isEmpty()){
           first = last;
       }else {
           oldLast.next = last;
       }
       queueLength++;
    }

    public Item dequeue(){
        Item res = first.item;
        first = first.next;
        if (isEmpty()){
            last = null;
        }
        queueLength--;
        return res;
    }
}
