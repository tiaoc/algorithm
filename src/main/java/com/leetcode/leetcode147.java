package com.leetcode;

public class leetcode147 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode t1 = new ListNode(3);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(1);
        head.next = t1;
        t1.next = t2;
        t2.next = t3;
        ListNode ff = insertionSortList(head);
        System.out.println(ff.val);
        System.out.println(ff.next.val);
        System.out.println(ff.next.next.val);
        System.out.println(ff.next.next.next.val);
    }

    public static ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head.next,pre=head;
        while (cur != null) {
            if(pre.val>cur.val) {
                ListNode temp = dummy;
                while (temp.next.val < cur.val) {
                    temp = temp.next;
                }
                pre.next = cur.next;
                ListNode t = temp.next;
                temp.next = cur;
                cur.next = t;
                cur = pre.next;
            }else{
                pre=pre.next;
                cur=cur.next;
            }
        }
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
