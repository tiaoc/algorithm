package com.server2023;

import java.util.Comparator;
import java.util.List;

public class leetcode6955 {
    // limit相同时，如何添加？
    // 严格大于，意味着必须添加一个新的。
    // 前一个数字可能不够用吗
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        usageLimits.sort(Comparator.comparingInt(a->-a));
        int max =Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int cur =0;
        for(int i=0;i<usageLimits.size();i++){
            left = usageLimits.get(i) -1 ;
            cur = 1;
        }
        return 0;
    }
}
