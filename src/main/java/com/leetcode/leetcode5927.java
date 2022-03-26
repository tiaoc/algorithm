package com.leetcode;


public class leetcode5927 {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int curLen = 1;
        ListNode cur = head, pre = null;
        while (cur != null && cur.next != null) {
            ListNode e=cur;
            for(int i=0;i<curLen;i++){
                e=e.next;
                if(e==null){
                    curLen=i;
                    break;
                }
            }
            if (curLen % 2 == 0) {
                ListNode start = pre, end = cur;
                for (int i = 0; i < curLen; i++) {
                    if (i != curLen - 1 && cur.next == null) {
                        break;
                    }
                    ListNode temp = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = temp;
                }
                start.next = pre;
                end.next = cur;
            } else {
                for (int j = 0; j < curLen; j++) {
                    pre = cur;
                    cur = cur.next;
                    if (cur == null) {
                        return head;
                    }
                }
            }
            curLen++;
        }
        return head;
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
