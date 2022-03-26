package com.leetcode;

public class leetcode5943 {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        int len=1;
        ListNode cur=head;
        while(cur.next!=null){
            cur=cur.next;
            len++;
        }
        cur=dummyHead;
        for(int i=0;i<len/2;i++){
            cur=cur.next;
        }
        cur.next=cur.next.next;
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
