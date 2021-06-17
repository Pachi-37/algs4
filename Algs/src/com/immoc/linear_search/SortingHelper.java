package com.immoc.linear_search;

/**
 * @author pachi
 * @date 2021-6-13
 */
public class SortingHelper {

    private SortingHelper() {
    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {

        long startTime = System.nanoTime();

        if (sortName.equals("SelectionSort")) {
            SelectionSort.sort(arr);
        } else if (sortName.equals("InsertionSort")){
            InsertionSort.sort(arr);
            InsertionSort.sort3(arr);
        }

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;

        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortName + " failed");
        }

        System.out.println(String.format("%s , n = %d : %f s", sortName, arr.length, time));
    }
}
