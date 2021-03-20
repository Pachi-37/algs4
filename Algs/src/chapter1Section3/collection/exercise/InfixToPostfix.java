package chapter1Section3.collection.exercise;

import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

/**
 * @author pachi
 * @deprecated 编写一个过滤器 `InfixToPostfix`, 将算术表达式由中序表达式转变为后序表达式 1.3.10
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();

        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            if (str.equals(")")) {
                String num2;
                num2 = vals.pop();
                String op;
                op = ops.pop();
                String num1;
                num1 = vals.pop();
                vals.push(num1 + " " + num2 + " " + op);
            } else if (str.equals("+")) {
                ops.push(str);
            } else if (str.equals("-")) {
                ops.push(str);
            } else if (str.equals("*")) {
                ops.push(str);
            } else if (str.equals("/")) {
                ops.push(str);
            } else {
                vals.push(str);
            }
        }
        System.out.println(vals.pop());
    }
}
