package com.leetcode;

public class leetcode5930 {
    //遍历两次找到所有
    public int maxDistance(int[] colors) {
        int diff=0;
        for (int i=0;i<colors.length;i++){
            for(int j=i+1;j<colors.length;j++){
                if(colors[i]!=colors[j]){
                    diff=Math.max(diff,j-i);
                }
            }
        }
        return diff;
    }
}
