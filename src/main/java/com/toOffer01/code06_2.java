package com.toOffer01;

import java.util.ArrayList;
import java.util.Arrays;

public class code06_2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode ln=new ListNode(1);
        ListNode ln2=new ListNode(3);
        ln.next=ln2;
        ln2.next=new ListNode(2);
        int[] a=reversePrint(ln);
        for(int i=0;i<a.length;i++) {
            System.out.println(a[i]);
        }
    }
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static int[] reversePrint(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Integer[] a= new Integer[list.size()];
        if(listNode==null){
            int[] att=new int[0];
            return att;
        }
        list=reverse_list(listNode, list);
        a=list.toArray(a);
        int[] arr2 = Arrays.stream(a).mapToInt(Integer::valueOf).toArray();
        return arr2;
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
