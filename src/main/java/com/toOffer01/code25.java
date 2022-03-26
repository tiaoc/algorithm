package com.toOffer01;

public class code25 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        if(l1==null&&l2==null) return null;
        if(l2==null){
            result= new ListNode(l1.val);
            l1=l1.next;
        }else if(l1==null){
            result= new ListNode(l2.val);
            l2=l2.next;
        } else if(l1.val<l2.val) {
            result= new ListNode(l1.val);
            l1=l1.next;
        }else {
            result= new ListNode(l2.val);
            l2=l2.next;
        }
        result.next = mergeTwoLists(l1, l2);
        return result;
    }
}
