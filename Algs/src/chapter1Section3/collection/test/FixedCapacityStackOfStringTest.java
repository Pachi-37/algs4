package chapter1Section3.collection.test;

import chapter1Section3.collection.stack.FixedCapacityStackOfString;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author minix
 */
public class FixedCapacityStackOfStringTest {
    public static void main(String[] args) {
        FixedCapacityStackOfString capacityStack = new FixedCapacityStackOfString(20);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();

            if ("-".equals(item)) {
                capacityStack.push(item);
            } else if (!capacityStack.isEmpty()) {
                StdOut.print(capacityStack.pop() + " ");
            }

            StdOut.println("(" + capacityStack.size() + " left on stack)");
        }
    }
}
