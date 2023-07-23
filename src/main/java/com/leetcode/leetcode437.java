package com.leetcode;

import java.util.*;

public class leetcode437 {
    int res = 0;

    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        dfs2(root, targetSum, new ArrayList<>());
        return res;
    }

    public void dfs2(TreeNode root, int targetSum, List<Long> list) {
        if (root == null) {
            return;
        }
        List<Long> newList = new ArrayList<>();
        for (Long v : list) {
            newList.add(v + root.val);
        }
        newList.add((long) root.val);
        for (long v : newList) {
            if (v == targetSum) {
                res++;
            }
        }
        dfs2(root.left, targetSum - root.val, newList);
        dfs2(root.right, targetSum - root.val, newList);
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        Map<Long, Integer> map = new HashMap<>();
        // 0之前的前缀，相当于初始化n+1长度的数组
        map.put((long) 0, 1);
        dfs(root, 0, targetSum, map);
        return res;
    }

    public void dfs(TreeNode root, long seqVal, int targetSum, Map<Long, Integer> prefixMap) {
        if (root == null) {
            return;
        }
        seqVal += root.val;
        // 历史出现的前缀
        if (prefixMap.containsKey(seqVal - targetSum)) {
            res += prefixMap.get(seqVal - targetSum);
        }
        prefixMap.put(seqVal, prefixMap.getOrDefault(seqVal, 0) + 1);
        dfs(root.left, seqVal, targetSum, prefixMap);
        dfs(root.right, seqVal, targetSum, prefixMap);
        prefixMap.put(seqVal, prefixMap.get(seqVal) - 1);
    }



}
