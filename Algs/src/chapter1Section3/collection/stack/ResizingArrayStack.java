package chapter1Section3.collection.stack;

import java.util.Iterator;

/**
 * @author pachi
 * @deprecated 下压栈
 * 该段代码可能含有 `Unchecked cast` 警报：解决办法，将数组中的每个元素单独取出进行转换
 */
public class ResizingArrayStack<Item> implements Iterator<Item> {
    private Item[] resizingArrayStack = (Item[]) new Object[1];
    private int arrayLength = 0;

    public boolean isEmpty() {
        return 0 == arrayLength;
    }

    public int size() {
        return arrayLength;
    }

    private void resize(int max) {
        Item[] tmp = (Item[]) new Object[max];
        if (arrayLength >= 0) System.arraycopy(resizingArrayStack, 0, tmp, 0, arrayLength);
        resizingArrayStack = tmp;
    }

    public void push(Item item) {
        if (arrayLength == resizingArrayStack.length) {
            resize(2 * resizingArrayStack.length);
        }
        resizingArrayStack[arrayLength++] = item;
    }

    public Item pop() {
        Item item = resizingArrayStack[--arrayLength];
        if (resizingArrayStack.length < arrayLength / 4 && arrayLength > 0) {
            resize(resizingArrayStack.length / 2);
        }

        return item;
    }

    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }

    @Override
    public boolean hasNext() {
        return arrayLength > 0;
    }

    @Override
    public Item next() {
        return resizingArrayStack[--arrayLength];
    }

    public class ReverseArrayIterator implements Iterator<Item>{
        private int len = arrayLength;
        public boolean hasNext(){
            return len > 0;
        }

        public Item next(){
            return resizingArrayStack[--len];
        }

        public void remove(){}
    }
}
