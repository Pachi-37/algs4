package chapter1Section3.collection.exercise;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author pachi
 * @deprecated 编写一个可以迭代的 `Stack` 用例，它含有一个静态的 `Copy()` 方法，接收一个字符串的栈作为参数并返回该栈一个副本
 */
public class StackWithCopy<Item>  {
    Stack<Item> stack = new Stack<>();

    public static<Item> Stack copy(Stack<Item> stack){
        Stack<Item> s = new Stack<>();
        for (Item e :
                stack) {
            s.push(e);
        }

        return s;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }

        for (Object e :
                StackWithCopy.copy(stack)) {
            System.out.println(e);
        }
    }
}
