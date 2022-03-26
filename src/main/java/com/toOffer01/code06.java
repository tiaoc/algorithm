package com.toOffer01;

import java.util.ArrayList;

public class code06 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode ln=new ListNode(1);
        ListNode ln2=new ListNode(3);
        ln.next=ln2;
        ln2.next=new ListNode(2);
        list=printListFromTailToHead(ln);
        System.out.println(list.toString());
    }

    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode==null){
            return list;
        }
        return reverse_list(listNode, list);

    }

    public static ArrayList<Integer> reverse_list(ListNode listNode, ArrayList<Integer> list) {
        if (listNode.next == null) {
            list.add(listNode.val);
            return list;
        } else {
            reverse_list(listNode.next, list);
            list.add(listNode.val);
            return list;
        }
    }
}
