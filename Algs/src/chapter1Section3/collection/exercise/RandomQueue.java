package chapter1Section3.collection.exercise;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * @author pachi
 * @deprecated 随机队列。删除一个元素时，随机交换某个元素和末位置元素位置，之后像 `ResizingArrayStack` 一样删除并返回末位置元素。编写一个用例，使用 `RandomQueue<Card>` 在桥牌中发牌（每个人13张）
 */
public class RandomQueue<Item> {
    private static final int INIT = 1;

    private Item[] item = (Item[]) new Object[INIT];
    private int head;
    private int queueLength;

    public boolean isEmpty() {
        return queueLength < 0;
    }


    public void enqueue(Item val) {
        if (queueLength == item.length) {
            resize(item.length * 2);
        }
        item[queueLength++] = val;
    }

    public Item dequeue() {
        Item res;
        int index = StdRandom.uniform(queueLength);
        if (isEmpty()) {
            throw new RuntimeException("The queue is empty");
        } else {
            res = item[index];
            item[index] = item[queueLength - 1];
            queueLength--;
            if (queueLength == item.length / 4) {
                resize(queueLength * 2);
            }
        }
        return res;
    }

    public int size(){
        return queueLength;
    }

    private void resize(int length) {
        Item[] temp = (Item[]) new Object[length];
        if (queueLength >= 0) System.arraycopy(item, 0, temp, 0, queueLength);
        item = temp;
    }

    public Item sample() {
        return item[StdRandom.uniform(queueLength)];
    }

    public Iterator<Item> iterator(){
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item>{
        private int len = queueLength;

        @Override
        public boolean hasNext() {
            return queueLength > 0;
        }

        @Override
        public Item next() {
            int index = StdRandom.uniform(len);
            Item tmp = item[index];
            item[index] = item[queueLength--];
            return tmp;
        }
    }

    public static class Card {
        int value;
        int type;
    }

    public static void main(String[] args) {
        RandomQueue<Card> cards = new RandomQueue<>();
        RandomQueue<Card> test = new RandomQueue<>();


        for (int value = 1; value <= 13; value++)
            for (int type = 1; type <= 4; type++) {
                Card c = new Card();
                c.value = value;
                c.type = type;
                cards.enqueue(c);
            }

        for (int value = 1; value <= 13; value++)
            for (int type = 1; type <= 4; type++) {
                Card c = new Card();
                c.value = value;
                c.type = type;
                test.enqueue(c);
            }

        StdOut.printf("---Format:(CardValue,CardType)---\n");
        StdOut.printf("\nperson 1-----\n");
        for (int i = 1; i <= 13; i++) {
            Card c = cards.dequeue();
            StdOut.print("(" + c.value + "," + c.type + ")");
        }

        StdOut.printf("\nperson 2-----\n");
        for (int i = 1; i <= 13; i++) {
            Card c = cards.dequeue();
            StdOut.print("(" + c.value + "," + c.type + ")");
        }

        StdOut.printf("\nperson 3-----\n");
        for (int i = 1; i <= 13; i++) {
            Card c = cards.dequeue();
            StdOut.print("(" + c.value + "," + c.type + ")");
        }

        StdOut.printf("\nperson 4-----\n");
        for (int i = 1; i <= 13; i++) {
            Card c = cards.dequeue();
            StdOut.print("(" + c.value + "," + c.type + ")");
        }

        Iterator<Card> iterator = test.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + " ");
        System.out.println();
        for (int i = 0; i < test.size(); i++)
            System.out.print(test.dequeue() + " ");

    }
}

