package com.immoc.linear_search;

/**
 * @author pachi
 */
public class SelectionSort {
    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {

            // 选择 arr[i..)中最小值的索引
            int minIndex = i;

            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int beginIndex, int minIndex) {

        E tmp = arr[beginIndex];
        arr[beginIndex] = arr[minIndex];
        arr[minIndex] = tmp;
    }

    public static void main(String[] args) {

        int n = 1000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        long startTime = System.nanoTime();
        SelectionSort.sort(arr);
        long endTime = System.nanoTime();

        if (!SortingHelper.isSorted(arr)){
            throw new RuntimeException("SelectionSort failed");
        }

        System.out.println("Time: " + (double)(endTime - startTime) / 1000000000);
    }
}
