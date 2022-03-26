package com.toOffer02;

public class code52 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /* 不能这么写，这样排除了公共节点等于null，退出的结果，造成没有公共节点就死循环
        应当允许tempA、tempB=null
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA=headA,tempB=headB;
        while(tempA!=tempB){
            tempA=tempA.next;//应当允许tempA=null
            if(tempA==null) tempA=headB;
            tempB=tempB.next;
            if(tempB==null) tempB=headA;
        }
        return tempA;
    }
     */
    //第一二条线不等长，第一条线加第二条线的开始，第二条线加第一条线的开始，走过了相同的长度
    //会到达公共节点，相遇。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA=headA,tempB=headB;
        while(tempA!=tempB){
            tempA=tempA==null?headB:tempA.next;
            tempB=tempB==null?headA:tempB.next;
        }
        return tempA;
    }
}
