package com.leetcode;

public class leetcode236 {
    // 递归查找左右子节点
    // 左节点是p或q的父节点
    // 当前节点是p或q
    // 当前节点不是p也不是q的父节点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null) {
            if (root == p || root == q || right !=null) {
                return root;
            }
            return left;
        }
        if (root == p || root == q) {
            return root;
        }
        return right;
    }
}
