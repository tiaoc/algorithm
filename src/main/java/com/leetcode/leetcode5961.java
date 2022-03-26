package com.leetcode;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class leetcode5961 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int pairSum(ListNode head) {
        Deque<ListNode> stack =new ArrayDeque<>();
        ListNode cur = head;
        int res=0;
        while(cur!=null){
            stack.addLast(cur);
            cur=cur.next;
        }
        cur = head;
        int len=stack.size();
        int i=0;
        while(i<len/2){
            res=Math.max(stack.pollLast().val + cur.val,res);
            cur=cur.next;
            i++;
        }
        return res;
    }

}
