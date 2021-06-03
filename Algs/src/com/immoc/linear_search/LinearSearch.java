package com.immoc.linear_search;

/**
 * @author pachi
 */
public class LinearSearch {
    public static int search(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] data = {24, 18, 12, 9, 16, 66, 32, 4};

        int res = LinearSearch.search(data, 16);
        System.out.println(res);

        int result = LinearSearch.search(data, 1);
        System.out.println(result);
    }
}
