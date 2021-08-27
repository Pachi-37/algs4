package com.immoc.quick;

import com.immoc.linear_search.ArrayGenerator;
import com.immoc.linear_search.InsertionSort;
import com.immoc.linear_search.SortingHelper;

import java.util.Random;

public class QuickSort {

    private QuickSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {

        Random rnd = new Random();

        sort(data, 0, data.length - 1, rnd);
    }

    private static <E extends Comparable<E>> void sort(E[] data, int l, int r, Random rnd) {

        if (l >= r) {
            return;
        } else if (r - l < 20) {
            InsertionSort.sort(data);
            return;
        }

        int splitPoint = partition(data, l, r, rnd);
        sort(data, l, splitPoint - 1, rnd);
        sort(data, splitPoint + 1, r, rnd);
    }

    private static <E extends Comparable<E>> int partition(E[] data, int l, int r, Random rnd) {

        int splitPoint = l;
        int randomIndex = rnd.nextInt(r - l + 1) + l;
//        int randomIndex = (l + r) / 2;

        swap(data, randomIndex, l);

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
        Integer[] data = ArrayGenerator.generateRandomArray(1000, 1000);

        SortingHelper.sortTest("QuickSort", data);
    }
}
