package com.immoc.quick;

import com.immoc.linear_search.ArrayGenerator;
import com.immoc.linear_search.SortingHelper;

public class QuickSort {

    private QuickSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {

    }

    private static <E extends Comparable<E>> void sort(E[] data, int l, int r) {

        if (l >= r) {
            return;
        }

        int splitPoint = l;
        E temp = data[l];

        for (int i = splitPoint + 1; i < r; i++) {

            if (data[i].compareTo(data[l]) < 0) {
                splitPoint++;
                if (i - splitPoint > 1) {
                    temp = data[i];
                    data[i] = data[splitPoint];
                    data[splitPoint] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] data = ArrayGenerator.generateRandomArray(10, 10);

        SortingHelper.sortTest("QuickSort", data);
    }
}
