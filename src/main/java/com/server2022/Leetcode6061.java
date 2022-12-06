package com.server2022;

public class Leetcode6061 {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int limit1 = total / cost1;
        int limit2 = total / cost2;
        long count = 0;
        for (int i = 0; i <= limit1; i++) {
            int resume=total-cost1 * i;
            int left =0,right=limit2;
            while(left<=right){
                int mid = (left+right)/2;
                if(mid*cost2<resume){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }
            count+=left;
        }
        return count;
    }
}
