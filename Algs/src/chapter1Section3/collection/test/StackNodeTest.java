package chapter1Section3.collection.test;

import chapter1Section3.collection.stack.StackNode;

/**
 * @author pachi
 * @deprecated 本例用来测试
 */
public class StackNodeTest {


    public static void main(String[] args) {
        StackNode<Integer> stackNode = new StackNode<>();
        stackNode.push(1);
        stackNode.push(4);
        System.out.println(stackNode.pop());
    }
}
