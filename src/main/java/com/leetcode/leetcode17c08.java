package com.leetcode;

import java.util.Arrays;

public class leetcode17c08 {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int[][] person=new int[height.length][2];
        for(int i=0;i<height.length;i++){
            person[i]=new int[]{height[i],weight[i]};
        }
        Arrays.sort(person,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int[] dp =new int[height.length];
        int res=0;
        for(int[] pair :person){
            int i= Arrays.binarySearch(dp,0,res,pair[1]);
            if(i<0){
                i=-(i+1);//–(length + 1)变为length
            }
            dp[i]=pair[1];
            if(i==res) ++res;
        }
        return res;
    }
//    1）  binarySearch(Object[], Object key)
//
//    a: 要搜索的数组
//
//    key：要搜索的值
//
//    如果key在数组中，则返回搜索值的索引；否则返回-1或“-”（插入点）。插入点是索引键将要插入数组的那一点，即第一个大于该键的元素的索引。
//
//    技巧：
//
//            [1] 搜索值不是数组元素，且在数组范围内，从1开始计数，得“ - 插入点索引值”；
//
//            [2] 搜索值是数组元素，从0开始计数，得搜索值的索引值；
//
//            [3] 搜索值不是数组元素，且大于数组内元素，索引值为 – (length + 1);
//
//            [4] 搜索值不是数组元素，且小于数组内元素，索引值为 – 1。
}
