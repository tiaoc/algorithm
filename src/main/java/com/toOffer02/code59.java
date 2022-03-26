package com.toOffer02;

import java.util.LinkedList;

public class code59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return new int[0];
        }
        int index=0;
        int[] res =new int[nums.length-k+1];
        LinkedList<Integer> linkedList=new LinkedList<>();//双端队列
        for(int i=0;i<nums.length;i++){
            while(!linkedList.isEmpty()&&nums[linkedList.peekLast()]<=nums[i]){//双端队列非空，且双端队列的末尾值小于等于新值，把这些末尾值都删掉
                linkedList.pollLast();//双端队列末尾值弹出
            }
            linkedList.addLast(i);//双端队列末尾值加入新值的索引
            if(linkedList.peekFirst()==i-k){//双端队列第一个值的索引等于新值索引-k，即双端队列第一个值是需要弹出的值
                linkedList.pollFirst();
            }
            if(i>=k-1){//新值大于等于k（构建好窗口后输出窗口最大值）
                res[index++]=nums[linkedList.peekFirst()];
            }
        }
        return res;
    }
}
