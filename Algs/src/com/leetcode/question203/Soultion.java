package com.leetcode.question203;

/**
 * @author pachi
 */
public class Soultion {
    public ListNode removeElements(ListNode head, int val, int depth) {

        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in head");

        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + null);
            return null;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);

        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return ret;
    }

    private String generateDepthString(int depth) {

        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            ret.append("--");
        }

        return ret.toString();
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Soultion()).removeElements(head, 6, 0);
        System.out.println(res);

        System.out.println(sum(nums));
    }

    public static int sum(int[] arr) {
        return sum(arr, 0);
    }

    public static int sum(int[] arr, int l) {

        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }
}

