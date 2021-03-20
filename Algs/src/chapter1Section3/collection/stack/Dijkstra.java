package chapter1Section3.collection.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * @author minix
 * @deprecated 双栈算数表达式求值
 */
public class Dijkstra {
    public static void main(String[] args) {
        // 创建两个栈分别用来保存算数表达式中的运算符和值
        Stack<String> ops = new Stack<String>();
        Stack<Double> val = new Stack<Double>();

        while (!StdIn.isEmpty()) {
            String tmp = StdIn.readString();

            if ("(".equals(tmp)) {
                ;
            } else if ("+".equals(tmp) || "-".equals(tmp) || "*".equals(tmp) || "/".equals(tmp)) {
                ops.push(tmp);
            } else if (")".equals(tmp)) {
                String op = ops.pop();
                if ("+".equals(op)){
                    val.push(val.pop() + val.pop());
                }else if ("-".equals(op)){
                    val.push(val.pop() - val.pop());
                }else if ("*".equals(op)){
                    val.push(val.pop() * val.pop());
                }else {
                    val.push(val.pop() / val.pop());
                }
            }else {
                val.push(Double.parseDouble(tmp));
            }
        }
        System.out.println(val.pop());
    }
}
