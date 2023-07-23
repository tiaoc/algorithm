package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode113 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        dfs(root, targetSum, new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> list) {
        list.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        if (root.left != null) {
            dfs(root.left, targetSum - root.val, list);
        }
        if (root.right != null) {
            dfs(root.right, targetSum - root.val, list);
        }
        list.remove(list.size() - 1);
    }
}
