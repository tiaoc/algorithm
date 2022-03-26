package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(0);
        boolean flag=true;
        while (flag) {
            flag = false;
            PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
                public int compare(ListNode a, ListNode b) {
                    return a.val - b.val;
                }
            });
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    queue.offer(lists[i]);
                    flag = true;
                }
            }
            ListNode cur = queue.poll();
            for (int i = 0; i < lists.length; i++) {
                if (cur == lists[i]) {
                    lists[i] = lists[i].next;
                    break;
                }
            }
            dummyHead.next = cur;
        }
        return dummyHead.next;
    }
}
class ListNode {
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
