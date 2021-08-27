package com.immoc.special_case;

import com.immoc.linear_search.SortingHelper;
import com.immoc.quick.QuickSort;

import java.util.Scanner;

/**
 * @author pachi
 * @date 2021-8-26
 * @deprecated 生成特殊案例，使得特定算法实现性能退化
 */
public class ArrayGenerator {

    private static int mid;

    public static Integer[] generateSpecialArrayToQuickSort(int length) {

        Integer[] data = new Integer[length];

        generateSpecialArrayToQuickSort(data, 0, length - 1, 0);

        return data;
    }

    private static void generateSpecialArrayToQuickSort(Integer[] data, int l, int r, int val) {

        if (l > r) {
            return;
        }
        int mid = (r + l) / 2;
        data[mid] = val;

        swap(data, l, mid);
        generateSpecialArrayToQuickSort(data, l + 1, r, val + 1);
        swap(data, l, mid);
    }

    private static void swap(Integer[] data, int l, int r) {

        Integer temp = data[l];
        data[l] = data[r];
        data[r] = temp;
    }

    public static void main(String[] args) {

        Integer[] data = generateSpecialArrayToQuickSort(1000);

        SortingHelper.sortTest("QuickSort", data);
    }
}
