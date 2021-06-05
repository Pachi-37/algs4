package com.immoc.linear_search;

/**
 * @author pachi
 */
public class LinearSearch {
    private LinearSearch() {
    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Integer[] data = ArrayGenerator.generateOrderedArray(4000);

        long start = System.nanoTime();

        LinearSearch.search(data, 4000);

        long end = System.nanoTime();

        double time = (end - start) / 1000000000.0;
        System.out.println(time + "s");
    }
}
