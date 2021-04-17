package chapter1Section3.collection.exercise;

import java.util.Stack;

/**
 * @author pachi
 * @deprecated 用有限个栈实现队列，保证每个队列操作都是常数次
 */
public class StackQueue<Item> {
    private Stack<Item> H = new Stack<>();
    private Stack<Item> T = new Stack<>();

    private Stack<Item> HBuffer = new Stack<>();
    private Stack<Item> HFlip = new Stack<>();
    private Stack<Item> Tadd = new Stack<>();
    private Stack<Item> tmp;

    private int HeadLength;
    private int size;
    private boolean isCopying;
    private int needCopy;

    public void enqueue(Item item) {
        if (HBuffer.isEmpty()) {
            T.push(item);
        } else {
            Tadd.push(item);
        }
    }

    public void Dequeue() {
        // TODO
    }

    public Item peek() {
        if (isCopying){
            return HBuffer.peek();
        }
        return H.peek();
    }

    // 执行元素复制和栈交换
    private void swap() {
        H.clear();
        tmp = H;
        H = HBuffer;
        HBuffer = tmp;
        T.clear();
        tmp = Tadd;
        Tadd = T;
        T = tmp;
    }

    private boolean isEmpty() {
        return T.isEmpty() && H.isEmpty() && HBuffer.isEmpty() && HFlip.isEmpty() && Tadd.isEmpty();
    }

    private void popPush(Stack<Item> po, Stack<Item> pu) {
        if (po.isEmpty()) {
            throw new RuntimeException(po.getClass().getName() + "为空");
        }
        pu.push(po.pop());
    }

    private void peekPush(Stack<Item> pe,Stack<Item> pu){
        if (pe.isEmpty()){
            throw new RuntimeException(pe.getClass().getName() + "为空");
        }
        pu.push(pe.peek());
    }

    public int size(){
        return this.size;
    }
}
