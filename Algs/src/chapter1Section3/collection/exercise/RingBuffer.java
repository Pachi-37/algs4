package chapter1Section3.collection.exercise;

/**
 * @param <Item>
 * @author pachi
 * @deprecated 环形缓冲区。一种定长的先进先出的数据类型。
 */
public class RingBuffer<Item> {
    private static final int BUFFER_SIZE = 10;
    Item[] items;
    private int cur, bufferSize;

    public RingBuffer() {
        items = (Item[]) new Object[BUFFER_SIZE];
    }

    public boolean isEmpty() {
        return bufferSize == 0;
    }

    public int size() {
        return bufferSize;
    }

    public void enter(Item val) {
        if (bufferSize >= BUFFER_SIZE) {
            throw new RuntimeException("缓冲区已满...");
        }
        items[(cur + bufferSize) % BUFFER_SIZE] = val;
        bufferSize++;
    }

    public Item delete() {
        Item res;

        if (isEmpty()) {
            throw new RuntimeException("缓冲区为空...");
        } else {
            res = items[cur++];
        }

        return res;
    }

    public static void main(String[] args) {
        RingBuffer<Integer> ring = new RingBuffer<>();

        for (int i = 0; i < 5; i++) {
            ring.enter(i);
        }

        System.out.println(ring.delete() + ring.delete());
    }
}
