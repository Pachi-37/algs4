package com.imooc.sort.merge;

import com.immoc.linear_search.ArrayGenerator;
import com.immoc.linear_search.SortingHelper;
import com.immoc.utils.GenerateDepthString;

import java.util.Arrays;

/**
 * @author pachi
 */
public class MergeSort {

    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, 0, temp);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, int depth, E[] temp) {

        String depthString = GenerateDepthString.generate(depth);
        System.out.println(depthString + String.format("mergeSort arr [%d, %d]", l, r));

        if (l >= r) {
            return;
        }

        int mid = (l + r) / 2;
        sort(arr, l, mid, depth + 1, temp);
        sort(arr, mid + 1, r, depth + 1, temp);

        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            System.out.print(depthString);
            System.out.println(String.format("merge arr [%d, %d] and arr [%d, %d]", l, mid, mid + 1, r));
            merge(arr, l, mid, r, temp);
        }

        System.out.print(depthString);
        System.out.println(String.format("after mergeSort arr [%d, %d]", l, r));
        for (E e :
                arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    /**
     * 合并两个有序区间
     *
     * @param arr 数组
     * @param l   较小索引
     * @param mid 中间位置
     * @param r   较大索引
     * @param <E> 泛型
     */
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

        int n = 8;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);

        SortingHelper.sortTest("MergeSort", arr);
    }
}
