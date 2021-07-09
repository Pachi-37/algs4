package com.leetcode.question203;

/**
 * @author pachi
 */
public class Soultion {
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {

            if (cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Soultion()).removeElements(head, 6);
        System.out.println(res);
    }
}

