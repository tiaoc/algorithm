package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode6031 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if (nums[i] == key){
                queue.offer(i);
            }
        }
        for (int i=0;i<nums.length;i++){
            if (queue.isEmpty()){
                break;
            }
            int mid = queue.peek();
            if (Math.abs(i-mid)<=k){
                res.add(i);
            }
            if (i == mid + k){
                queue.poll();
            }
        }
        return res;
    }
}
