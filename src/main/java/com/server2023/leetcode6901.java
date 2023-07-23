package com.server2023;

import java.util.*;

public class leetcode6901 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int dis = 0;
        while (mainTank >= 5) {
            mainTank -= 5;
            dis += 50;
            if (additionalTank-- > 0) {
                mainTank++;
            }
        }
        dis += mainTank * 10;
        return dis;
    }

    // 数组1的最大值和数字2的最小值的差值
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int v = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            v = Math.min(nums[i] - nums[i - 1], v);
        }
        return v;
    }

    int res = 0;
    int mod = 1000000007;

    // 前一个和后一个是倍数。 小大小， 大小大， 传递性？
    // 链条，链条在某个时刻是否能形成？
    public int specialPerm(int[] nums) {
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0;j<nums.length;j++){
                if (i==j){
                    continue;
                }
                if (nums[j] % nums[i] == 0 || nums[i] % nums[j] == 0){
                    set.add(nums[j]);
                }
            }
            edges.put(nums[i],set);
        }
        Set<Integer> used = new HashSet<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(list, nums, visited, used, edges);
        return res;
    }

    private void dfs(List<Integer> list, int[] nums, boolean[] visited, Set<Integer> used,Map<Integer, Set<Integer>> edges ) {
        if (list.size() == nums.length) {
            res = (res + 1) % mod;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int last = list.size() > 0 ? list.get(list.size() - 1) : -1;
                if (last < 0 || last > 0 && last % nums[i] == 0 || nums[i] % last == 0) {
                    visited[i] = true;
                    used.add(nums[i]);
                    list.add(nums[i]);
                    dfs(list, nums, visited, used, edges);
                    visited[i] = false;
                    list.remove(list.size() - 1);
                    used.remove(nums[i]);
                }
            }
        }
    }
}
