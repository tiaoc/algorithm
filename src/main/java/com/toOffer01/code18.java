package com.toOffer01;

public class code18 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val){
            if(head.next!=null){
                head=head.next;
            }else{
                head.next=null;
            }
            return head;
        }
        ListNode node = head;
        while (val != node.next.val) {
            node = node.next;
        }

        if (node.next.next != null) {
            node.next = node.next.next;
        }else{
            node.next=null;
        }
        return head;
    }
}
