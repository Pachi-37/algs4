package chapter1Section3.collection.test;

/**
 * @author minix
 * @deprecated 使用泛型创建定容栈
 */
public class FixedCapacityStack<Item>{
    private Item[] fixedCapacityStack;
    private int len;

    public FixedCapacityStack(int cap){
        fixedCapacityStack = (Item[]) new Object[cap];
    }

    public boolean isEmpty(){
        return len == 0;
    }

    public int size(){
        return len;
    }

    public void push(Item item){
        fixedCapacityStack[len++] = item;
    }

    public Item pop(){
        return fixedCapacityStack[--len];
    }
}
