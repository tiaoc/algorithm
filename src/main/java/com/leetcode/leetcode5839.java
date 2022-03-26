package com.leetcode;

import java.util.PriorityQueue;

public class leetcode5839 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<piles.length;i++){
            queue.offer(piles[i]);
        }
        if(queue.isEmpty()){
            return 0;
        }
        for(int i=0;i<k;i++){
            double cur=(double) queue.poll();
            queue.offer((int) Math.ceil(cur/2));
        }
        int res=0;
        for(int i=0;i<piles.length;i++){
            res+=queue.poll();
        }
        return res;
    }
}
