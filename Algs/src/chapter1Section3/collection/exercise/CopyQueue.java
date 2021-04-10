package chapter1Section3.collection.exercise;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author pachi
 * @deprecated 复制队列。编写一个新的构造器
 * @param <Item>
 */
public class CopyQueue<Item> extends Queue<Item> {
    public CopyQueue(Queue<Item> q){
        int size = q.size();

        Item val;

        for (int i = 0; i < size; i++) {
            val = q.dequeue();
            this.enqueue(val);
            q.enqueue(val);
        }
    }

    public CopyQueue(){}

    public static void main(String[] args) {

        CopyQueue<String> queue = new CopyQueue<>();

        System.out.println("Please enter strings into queue:");
        while (!StdIn.isEmpty()){
            queue.enqueue(StdIn.readString());
        }

        CopyQueue<String> r = new CopyQueue<String>(queue);
        StdOut.println("After copy");
        StdOut.print("Left on queue r: ");
        for (String s : r) {
            StdOut.print(s + " ");
        }
        StdOut.println();
        StdOut.print("Left on queue queue: ");
        for (String s : queue) {
            StdOut.print(s + " ");
        }
        StdOut.println();

        r.dequeue();
        StdOut.println("After r.dequeue");
        StdOut.print("Left on queue r: ");
        for (String s : r) {
            StdOut.print(s + " ");
        }
        StdOut.println();
        StdOut.print("Left on queue queue: ");
        for (String s : queue) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    }
}
