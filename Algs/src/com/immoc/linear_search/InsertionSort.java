package com.immoc.linear_search;

public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 1; i < arr.length; i++) {

            // 将 arr[i] 插入到合适的位置
//            for (int j = i; j - 1 >= 0; j--) {
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    swap(arr, j, j - 1);
//                } else {
//                    break;
//                }
//            }
            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                swap(arr, j, j - 1);
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

    private static <E> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] dataSize = {1000, 100};
        for (int n :
                dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);

            SortingHelper.sortTest("InsertionSort", arr);
        }
    }
}
