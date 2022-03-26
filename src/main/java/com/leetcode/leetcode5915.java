package com.leetcode;

public class leetcode5915 {
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

    //记录第一个出现的极点，更新最后一个出现的极点及其最小距离
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1, last = -1;
        int idx = 1, minDis = -1, maxDis = -1;
        while (head != null && head.next != null && head.next.next != null) {
            if (head.val < head.next.val && head.next.next.val < head.next.val || head.val > head.next.val && head.next.next.val > head.next.val) {
                if(first!=-1) {
                    maxDis = idx - first;
                }
                if (first == -1) {
                    first = idx;
                }
                if (last != -1) {
                    if (minDis == -1) {
                        minDis = idx - last;
                    }else {
                        minDis = Math.min(minDis, idx - last);
                    }
                }
                last = idx;
            }
            head = head.next;
            idx++;
        }
        return new int[]{minDis, maxDis};
    }
}
