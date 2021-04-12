package chapter1Section3.collection.exercise;

import edu.princeton.cs.algs4.StdIn;

import java.util.Stack;

/**
 * @author pachi
 * @deprecated 文件编辑器的缓冲区
 */
public class Buffer {
    // 当前元素之前的元素
    private Stack<Character> front = new Stack<>();
    // 该元素之后元素
    private Stack<Character> after = new Stack<>();

    public Buffer() {

    }

    public void insert(char c) {
        front.push(c);
    }

    public char delete() {
        char res = front.pop();
        return res;
    }

    public void left(int k) {

        for (int i = 0; i < k; i++) {
            if (front.isEmpty()){
                throw new RuntimeException("Buffer overflow");
            } else {
                after.push(front.pop());
            }
        }
    }

    public void right(int k) {
        for (int i = 0; i < k; i++) {
            if (after.isEmpty()){
                throw new RuntimeException("Buffer overflow");
            } else {
                front.push(after.pop());
            }
        }
    }

    public int size() {
        return front.size() + after.size();
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        while (!StdIn.isEmpty()){
            buffer.insert(StdIn.readChar());
        }

        System.out.println(buffer.delete());
        buffer.left(12);
        System.out.println(buffer.delete());
    }
}
