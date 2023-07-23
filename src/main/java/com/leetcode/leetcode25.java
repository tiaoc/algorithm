package com.leetcode;

import com.base.ListNode;

public class leetcode25 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        System.out.println(new leetcode25().reverseKGroup(a, 2));
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre != null) {
            ListNode start = pre, end = pre;
            for (int i = 0; i < k; i++) {
                if (end.next != null) {
                    end = end.next;
                } else {
                    return dummy.next;
                }
            }
            ListNode[] mid = reverse(pre.next, end);
            start.next = mid[0];
            pre = mid[1];
        }
        return dummy.next;
    }

    private ListNode[] reverse(ListNode head, ListNode end) {
        ListNode cur = head.next;
        ListNode pre = head;
        head.next = end.next;
        while (pre != end) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return new ListNode[]{pre, head};
    }
}
