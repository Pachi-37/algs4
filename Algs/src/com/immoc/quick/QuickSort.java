package com.immoc.quick;

import com.immoc.linear_search.ArrayGenerator;
import com.immoc.linear_search.SortingHelper;

public class QuickSort {

    private QuickSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {
        sort(data, 0, data.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] data, int l, int r) {

        if (l >= r) {
            return;
        }

        int splitPoint = partition(data, l, r);
        sort(data, l, splitPoint - 1);
        sort(data, splitPoint + 1, r);
    }

    private static <E extends Comparable<E>> int partition(E[] data, int l, int r) {

        int splitPoint = l;
        E temp = data[l];

        for (int i = splitPoint + 1; i <= r; i++) {

            if (data[i].compareTo(data[l]) < 0) {
                splitPoint++;
                swap(data, splitPoint, i);
            }
        }

        swap(data, splitPoint, l);

        return splitPoint;
    }

    private static <E> void swap(E[] data, int l, int r) {
        E temp = data[l];
        data[l] = data[r];
        data[r] = temp;
    }

    public static void main(String[] args) {
        Integer[] data = ArrayGenerator.generateRandomArray(10, 10);

        SortingHelper.sortTest("QuickSort", data);
    }
}
