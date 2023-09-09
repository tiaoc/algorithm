package com.september2023;

import com.base.TreeNode;

import java.util.*;

public class leetcode449 {
    // 二叉搜索树，左节点小于父节点，右节点大于父节点
    // 左子树都小于父节
    // 递归？
    // 前序遍历 中左右
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (root != null) {
                sb.append(root.val).append(',');
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] arr = data.split(",");
        int[] nums = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        return dfs(nums, 0, arr.length);
    }

    private TreeNode dfs(int[] data, int start, int end) {
        if (start == end) {
            return null;
        }
        TreeNode node = new TreeNode(data[start]);
        int i = start + 1;
        while (i < data.length && data[i] < node.val) {
            i++;
        }
        TreeNode left = dfs(data, start + 1, i);
        TreeNode right = dfs(data, i, end);
        node.left = left;
        node.right = right;
        return node;
    }
}
