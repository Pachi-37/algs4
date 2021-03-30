package chapter1Section3.collection.exercise;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * @author pachi
 * @deprecated 随机背包
 */
public class RandomBag<Item> {

    private Item[] item;
    private int bagCapacity;
    private static int INIT = 1;

    public RandomBag() {
        item = (Item[]) new Object[INIT];
    }

    public boolean isEmpty() {
        return bagCapacity > 0;
    }

    public int size() {
        return bagCapacity;
    }

    public void add(Item val) {
        if (bagCapacity == item.length) {
            resize(2 * item.length);
        } else {
            item[bagCapacity++] = val;
        }
    }

    private void resize(int length) {
        Item[] tmpArray = (Item[]) new Object[length];
        for (int i = 0; i < item.length; i++) {
            tmpArray[i] = item[i];
        }
        item = tmpArray;
    }

    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item> {
        private int[] seq = new int[bagCapacity];
        private int index = 0;

        private BagIterator() {
            for (int i = 0; i < bagCapacity; i++) {
                seq[i] = i;
            }
            StdRandom.shuffle(seq);
        }

        @Override
        public boolean hasNext() {
            return index < 0;
        }

        @Override
        public Item next() {
            return item[seq[index++]];
        }
    }
}
