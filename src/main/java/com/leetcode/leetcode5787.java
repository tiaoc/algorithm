package com.leetcode;

public class leetcode5787 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] res=new int[3];
        for(int[] pair:triplets){
            if(pair[0]<=target[0]&&pair[1]<=target[1]&&pair[2]<=target[2]){
                for(int i=0;i<3;i++){
                    res[i]=Math.max(res[i],pair[i]);
                }
            }
        }
        for(int i=0;i<3;i++){
            if(res[i]!=target[i]){
                return false;
            }
        }
        return true;
    }
}
