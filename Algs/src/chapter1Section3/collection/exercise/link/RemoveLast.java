package chapter1Section3.collection.exercise.link;

/**
 * @author pachi
 * @deprecated 给出一段代码删除链表的尾结点，其中链表的首结点为 `first`
 */
public class RemoveLast<Item> {
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

    public Item removeLast(){
        Item item = last.item;
        if (isEmpty()){
            throw new RuntimeException("List is empty");
        }

        Node tmp = first;
        Node cur = first;

        while (tmp.next != null){
            cur = tmp;
            tmp = tmp.next;
        }

        cur.next = null;
        last = cur;
        nodeLength--;

        return item;
    }
}
