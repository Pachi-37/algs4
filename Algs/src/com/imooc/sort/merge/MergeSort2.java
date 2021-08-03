package com.imooc.sort.merge;

import com.immoc.linear_search.ArrayGenerator;
import com.immoc.linear_search.SortingHelper;

import java.util.Arrays;

/**
 * @author pachi
 */
public class MergeSort2 {

    private MergeSort2() {
    }

    /**
     * 使用自底向上排序
     *
     * @param <E> 泛型
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {

        E[] temp = Arrays.copyOf(arr, arr.length);

        int n = arr.length;

        // 遍历合并的区间
        for (int sz = 1; sz < n; sz += sz) {

            // 遍历合并区间元素
            for (int i = 0; i + sz < n; i += sz + sz) {
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0)
                    merge(arr, i, i + sz - 1, Math.min(n - 1, i + sz + sz - 1), temp);
            }
        }
    }
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {

        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k++) {

            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 5000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);

        SortingHelper.sortTest("MergeSortBU", arr);
    }
}
