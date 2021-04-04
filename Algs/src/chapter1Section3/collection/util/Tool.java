package chapter1Section3.collection.util;

public class Tool<Item> {
    public static <Item> void resize(Item[] items, int length) {
        Item[] tmp = (Item[]) new Object[length];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        items = tmp;
    }
}
