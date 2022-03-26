package com.toOffer01;

public class code22 {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode h2=new ListNode(2);
        ListNode h3=new ListNode(4);
        ListNode h4=new ListNode(8);
        head.next=h2;
        h2.next=h3;
        h3.next=h4;
        ListNode result=getKthFromEnd(head,2);
        System.out.println(result.val);
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow=head,fast=head;
        while(k>0) {
            fast=fast.next;
            k--;
        }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
