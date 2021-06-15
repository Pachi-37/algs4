package com.immoc.linear_search;

public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[i]) >= 0) {
                    insertTo(arr, j, i);
                }
            }
        }
    }

    private static <E> void insertTo(E[] arr, int order, int index) {
        E tmp = arr[index];

        if (index - order >= 0) System.arraycopy(arr, order, arr, order + 1, index - order);
        if (order + 1 < index) {
            arr[order + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int n = 100;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);

        InsertionSort.sort(arr);

        for (Integer e :
                arr) {
            System.out.println(e);
        }
    }
}
