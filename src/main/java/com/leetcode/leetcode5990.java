package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode5990 {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 1){
            res.add(nums[0]);
            return res;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] != nums[i] && nums[i - 1] != nums[i] - 1 && nums[i + 1] != nums[i] && nums[i + 1] != nums[i] + 1) {
                res.add(nums[i]);
            }
        }
        if (nums[1] != nums[0] && nums[1] != nums[0] + 1) {
            res.add(nums[0]);
        }
        if (nums[nums.length - 2] != nums[nums.length - 1] && nums[nums.length - 2] != nums[nums.length - 1] - 1) {
            res.add(nums[nums.length - 1]);
        }
        return res;
    }
}
