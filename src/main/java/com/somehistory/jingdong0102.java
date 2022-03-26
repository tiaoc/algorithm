package com.somehistory;

public class jingdong0102 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//    private static ListNode func(ListNode root) {
//        ListNode left=root;
//        ListNode mid=root.next;
//        ListNode right=mid.next;
//        while(right!=null){
//            if(left==root){
//                left.next=null;
//            }
//            mid.next=left;
//            left=mid;
//            mid=right;
//            right=right.next;
//        }
//        return mid;
//    }
    //面试失败版本
    private static ListNode func(ListNode root) {
        if(root.next==null){
            return root;
        }
        ListNode mid=root.next;
        ListNode temp=func(mid.next);
        mid.next=root;
        return temp;
    }
    //递归真实版本
    //res只是用来当头结点，具体操作是两条线，换一个，空一个；
    //1—>2,root.next.next=root;变为1<-2,而原本指向2的1.next，指向空。
    private static ListNode funnc(ListNode root) {
        if(root==null||root.next==null){
            return root;
        }
        ListNode res=funnc(root.next);
        root.next.next=root;
        root.next=null;
        return res;
    }
    //双指针版本

}
