package chapter1Section3.collection.exercise;

import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

/**
 * @author pachi
 * @deprecated 编写一段程序，从标准输入得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式 1.3.9
 * 例如，给定输入：
 * 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * 你的程序应该输出:
 * ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 */
public class CompletingParentheses {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<String> val = new Stack<>();
        while (!StdIn.isEmpty()) {
            String string = StdIn.readString();
            if (string.equals(")")) {
                String op  = ops.pop();
                val.push("( " + val.pop() + " " + op + " " + val.pop() + " )");
            } else if (string.equals("+")) {
                ops.push(string);
            } else if (string.equals("-")) {
                ops.push(string);
            } else if (string.equals("*")) {
                ops.push(string);
            } else if (string.equals("/")) {
                ops.push(string);
            } else {
                val.push(string);
            }
        }
        System.out.println(val.pop());
    }
}
