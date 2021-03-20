package chapter1Section3.collection.exercise;

import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

/**
 * @author PACHI
 * @deprecated 编写一个 `Stack` 的用例 `Parentheses` 从标准输入中读取一个文本流并使用栈判断其中的括号是否配对完整。例如，对于[()]{}{[()()]()} 程序应该打印 `true` 对于[(]] 则打印 `false` 1.3.4
 */
public class Parentheses {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String string = StdIn.readString();
        String[] inputs = string.split("");
        for (String input : inputs
        ) {
            if (input.equals("{") || input.equals("[") || input.equals("(")) {
                stack.push(input);
            } else if (!stack.isEmpty()) {

                if (input.equals("}")) {
                    if (!stack.pop().equals("{")) {
                        System.out.println(false);
                        return;
                    }
                } else if (input.equals("]")) {
                    if (!stack.pop().equals("[")) {
                        System.out.println(false);
                        return;
                    }
                } else if (input.equals(")")) {
                    if (!stack.pop().equals("(")) {
                        System.out.println(false);
                        return;
                    }

                }
            }
        }
        System.out.println(stack.isEmpty());
    }
}
