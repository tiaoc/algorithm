package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode5934 {
    //删除最小的n-k个数,给定一个不删的最大数字，和这个数字删除/留下的个数，删掉其他的
    //知道最小的数字在哪个位置，
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> queue= new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i=0;i<nums.length;i++){
            if(queue.size()== k && !queue.isEmpty() &&queue.peek()[0]<nums[i]){
                queue.poll();
                queue.offer(new int[]{nums[i],i});
            }else if(queue.size()< k){
                queue.offer(new int[]{nums[i],i});
            }
        }
        System.out.println(queue.size());
        int[][] list= new int[queue.size()][];
        int i=0;
        while(!queue.isEmpty()){
            list[i]=queue.poll();
            i++;
        }
        Arrays.sort(list, Comparator.comparingInt(o -> o[1]));
        int[] res=new int[k];
        for(int j=0;j<k;j++){
            res[j]=list[j][0];
        }
        return res;
    }
}
