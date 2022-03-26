package com.toOffer01;

public class code24 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode slow=head,fast,now;
        now=head.next;
        fast=now.next;
        head.next=null;
        while(fast!=null){
            now.next=slow;
            slow=now;
            now=fast;
            fast=fast.next;
        }
        now.next=slow;
        return now;
    }
}
