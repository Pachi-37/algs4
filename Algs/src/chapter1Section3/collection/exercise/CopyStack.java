package chapter1Section3.collection.exercise;

import java.util.Stack;

/**
 * @author pachi
 * @deprecated 复制栈，为基于链表实现的栈编写一个新的构造函数
 * @param <Item>
 */
public class CopyStack<Item> extends Stack<Item> {
    public CopyStack(CopyStack<Item> s){
       CopyStack<Item> stack = new CopyStack<>();

       int size = stack.size();

       Item val;
        for (int i = 0; i < size; i++) {
            val = s.peek();
            this.push(val);
            stack.push(val);
        }

        s = stack;
    }
    public CopyStack(){}

}
