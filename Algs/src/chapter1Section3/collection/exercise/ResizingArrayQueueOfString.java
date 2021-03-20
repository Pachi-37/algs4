package chapter1Section3.collection.exercise;

import java.util.Iterator;

/**
 * @author pachi
 * @deprecated 编写一个程序 `ResizingArrayQueueOfString`，使用定长数组实现队列的抽象，然后扩展实现，使用调整数组的方法突破大小限制
 */
public class ResizingArrayQueueOfString<Item> implements Iterator<Item> {
    private Item[] items;
    private int maxSize;
    private int first;
    private int last;

    public ResizingArrayQueueOfString(int maxSize){
        items = (Item[]) new Object[maxSize];
        first = last = 0;
    }

    public boolean isEmpty(){
        return first == last;
    }

    public int size(){
        return last - first;
    }

    public void enqueue(Item item){
        if(last == maxSize){
            resizing(maxSize * 2);
        }
        items[last++] = item;
    }

    private void resizing(int num) {
        Item[] tmp = (Item[]) new Object[num];
        int i = 0;
        for (int j = first; j < last; j++) {
            tmp[i++] = items[j];
            items = tmp;
            maxSize = num;
            last = last - first;
            first = 0;
        }
    }

    public Item dequeue(){
        if(size() < maxSize / 4){
            resizing(2 * size());
        }
        Item item = items[first++];
        return item;
    }

    @Override
    public boolean hasNext() {
        return isEmpty();
    }

    @Override
    public Item next() {
        return dequeue();
    }
}
