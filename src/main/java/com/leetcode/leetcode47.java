package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len ==0){
            return res;
        }
        Arrays.sort(nums);//排序是剪枝的前提

        boolean[] used =new boolean[len];
        List<Integer> path=new ArrayList<>();
        dfs(nums,len,0,path,used,res);
        return res;
    }
    private void dfs(int[] nums,int len,int depth,List<Integer> path,
                     boolean[] used,List<List<Integer>> res){
        if(depth==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<len;i++){
            if(!used[i]){
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {//i-1是排序后数组nums，前一个不相同则不重复
                    continue;
                }
                path.add(nums[i]);
                used[i]=true;

                dfs(nums,len,depth+1,path,used,res);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                used[i]=false;
                path.remove(path.size()-1);
            }
        }
    }
}
