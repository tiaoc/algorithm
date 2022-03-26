package com.leetcode;

import java.util.ArrayList;

public class leetcode5904 {
    //最大值是多少，构成最大值的数。
    //互补，由于最大值肯定是某个数贡献的，所以不用考虑某位多出了1
    //互补，且贡献的位填满了最大值
    //不能出现填充不了的情况
    //某个最小子集，它的外扩全部都是。
    //找多个最小子集，然后填充
    //搜索到某个数，满足了，把它后面的全加上
    //
    int max = 0;
    int res = 0;

    public int countMaxOrSubsets(int[] nums) {
        for (int num : nums) {
            max = max | num;
        }
        dfs(0,nums,new ArrayList<>());
        return res;
    }

    private void dfs(int cur, int[] nums, ArrayList<Integer> temp) {
        if (cur == nums.length) {
            int val=0;
            for (Integer num:temp){
                val|=num;
            }
            if(val==max){
                res++;
            }
            return;
        }
        dfs(cur + 1, nums, new ArrayList<>(temp));
        temp.add(nums[cur]);
        dfs(cur + 1, nums, new ArrayList<>(temp));
    }
}
