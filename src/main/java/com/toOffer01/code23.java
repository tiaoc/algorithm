package com.toOffer01;

public class code23 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode MeetingNode(ListNode head){
        if (head ==null) return null;
        ListNode slow=head.next;
        if(slow ==null){
            return null;
        }
        ListNode fast=slow.next;
        while (fast!=null&&slow!=null){
            if(fast==slow){
                return slow;
            }
            slow=slow.next;
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
            }//fast走两步
        }
        return null;
    }
    public ListNode EntryNodeOfLoop(ListNode head) {
        ListNode loopStart=MeetingNode(head);
        if(loopStart==null) return null;
        ListNode move = loopStart;
        int count=0;
        while(move!=loopStart){
            move=move.next;
            count++;
        }//得到环的节点数目

        while(count>0){
            move=head.next;
            count--;
        }
        while(head!=move){
            head=head.next;
            move=move.next;
        }
        return head;
    }

}
