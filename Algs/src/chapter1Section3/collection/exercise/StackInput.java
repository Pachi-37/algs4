package chapter1Section3.collection.exercise;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

/**
 * @author pachi
 * @deprecated 给定以下输入，`java Stack` 的输出是什么？ `it was - the best - of times - - - it was - the - -` 1.3.2
 */
public class StackInput {
    @Test
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                stack.push(item);
            } else if (!stack.isEmpty()) {
                StdOut.print(stack.pop() + " ");
            }
            StdOut.println("(" + stack.size() + " left on stack");
        }
    }
}
