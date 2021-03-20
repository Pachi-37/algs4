package chapter1Section3.collection.exercise;

/**
 * @author pachi
 * @deprecated 为 `FixedCapacityStackOfString` 添加一个 `isFull()` 方法 1.3.1
 */
public class FixedCapacityStackOfString {
    private String[] fixedCapacityStack;
    private int len;

    public FixedCapacityStackOfString() {
    }

    public FixedCapacityStackOfString(int cap) {
        fixedCapacityStack = new String[cap];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull(){
        return len == fixedCapacityStack.length;
    }

    public int size() {
        return len;
    }

    public void push(String item) {
        fixedCapacityStack[len++] = item;
    }

    public String pop() {
        return fixedCapacityStack[--len];
    }
}
