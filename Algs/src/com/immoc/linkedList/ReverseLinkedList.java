package com.immoc.linkedList;

/**
 * @author pachi
 * @date 2021-7-16
 * @deprecated 翻转链表 source: https://leetcode.com/problems/reverse-linked-list/submissions/
 */
public class ReverseLinkedList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

//    public ListNode reverseList(ListNode head) {
//
//        ListNode pre = null;
//        ListNode cur = head;
//
//        while (cur != null) {
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//
//        return pre;
//    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;

        return reverseList(pre, head);
    }

    private ListNode reverseList(ListNode pre, ListNode cur) {

        if (cur == null) {
            return pre;
        }

        ListNode next = cur.next;
        cur.next = pre;
        pre = cur;

        return reverseList(pre, next);
    }
}
