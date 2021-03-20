package chapter1Section3.collection.stack;

/**
 * @author minix
 * @deprecated 定容栈
 */
public class FixedCapacityStackOfString {
    private String[] fixedCapacityStack;
    private int len;

    public FixedCapacityStackOfString(){}

    public FixedCapacityStackOfString(int cap){
        fixedCapacityStack = new String[cap];
    }

    public boolean isEmpty(){
        return len == 0;
    }

    public int size(){
        return len;
    }

    public void push(String item){
        fixedCapacityStack[len++] = item;
    }

    public String pop(){
        return fixedCapacityStack[--len];
    }
}
