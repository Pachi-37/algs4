package com.immoc.linear_search;

/**
 * @author pachi
 */
public class SelectionSort {
    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {

        // 选择排序循环不变量为 arr[i..n)未排序 arr[0..i) 已排序
//        for (int i = 0; i < arr.length; i++) {
//
//            // 选择 arr[i..)中最小值的索引
//            int minIndex = i;
//
//            for (int j = i; j < arr.length; j++) {
//                if (arr[j].compareTo(arr[minIndex]) < 0) {
//                    minIndex = j;
//                }
//            }
//
//            swap(arr, i, minIndex);
//        }
        // 选择排序循环不变量为 arr[i..n)已排序 arr[0..i)未排序
        for (int i = arr.length - 1; i > -1; i--) {

            int maxIndex = i;

            for (int j = i; j > -1; j--) {
                if (arr[j].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            swap(arr, i, maxIndex);
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
        SortingHelper.sortTest("SelectionSort", arr);
//        SelectionSort.sort(arr);
    }
}
