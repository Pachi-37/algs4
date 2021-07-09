package com.leetcode.question203;

/**
 * @author pachi
 */
public class Soultion {
    public static ListNode removeElements(ListNode head, int val) {

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
        ListNode head = new ListNode(1);
        ListNode cur = new ListNode(2);
        head.next = cur;
        cur.next = new ListNode(6);
        cur = cur.next;
        cur.next = new ListNode(4);

        Soultion.removeElements(head, 7);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

