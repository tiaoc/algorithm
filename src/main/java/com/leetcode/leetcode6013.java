package com.leetcode;

public class leetcode6013 {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummyHead = new ListNode(0, head), cur = head, pre = dummyHead;
        while (cur != null) {
            if (cur.val == 0) {
                int sum = 0;
                cur = cur.next;
                while (cur != null && cur.val != 0) {
                    sum += cur.val;
                    cur = cur.next;
                }
                cur = new ListNode(sum, cur);
                if (sum == 0) {
                    pre.next= null;
                    break;
                }
                pre.next = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public class ListNode {
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
}
