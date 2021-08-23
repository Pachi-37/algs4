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

                temp = data[i];
                data[i] = data[splitPoint];
                data[splitPoint] = temp;
            }
        }

        temp = data[l];
        data[l] = data[splitPoint];
        data[splitPoint] = data[l];

        return splitPoint;
    }

    public static void main(String[] args) {
        Integer[] data = ArrayGenerator.generateRandomArray(10, 10);

        SortingHelper.sortTest("QuickSort", data);
    }
}
