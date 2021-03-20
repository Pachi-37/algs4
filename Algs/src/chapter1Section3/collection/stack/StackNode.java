package chapter1Section3.collection.stack;

/**
 * @author pachi
 */
public class StackNode<Item> {
    public class Node {
        Item item;
        Node next;
    }

    private Node first;
    private int stackSize;

    public boolean isEmpty(){
        return first == null;
    }

    public void push(Item val){
        Node oldFirst = first;
        first = new Node();
        first.item = val;
        stackSize++;
        first.next = oldFirst;
    }

    public Item pop(){
        Item item = first.item;
        Node newFirst = first.next;
        first = null;
        stackSize--;
        first = newFirst;
        return item;
    }

    public Item peek(){
        return first.item;
    }
}
