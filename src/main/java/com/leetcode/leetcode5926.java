package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode5926 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue =new LinkedList<>();
        int time=0;
        while(tickets[k]!=0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] == 0) {
                    continue;
                }
                tickets[i]--;
                time++;
                if(tickets[k]==0){
                    break;
                }
            }
        }
        return time;
    }
}
