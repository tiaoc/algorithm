package com.september2023;

import com.base.TreeNode;

public class leetcode1123 {
    TreeNode res;
    int depth;

    // 先找到最大深度，再找到命中最大深度所有节点的祖先。
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        res = root;
        depth = dfs(root);
        dfs2(root, 0);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean dfs2(TreeNode root, int curDepth) {
        if (root == null) {
            return curDepth == depth;
        }
        boolean leftHit = dfs2(root.left, curDepth + 1);
        boolean rightHit = dfs2(root.right, curDepth + 1);
        if (leftHit && rightHit) {
            res = root;
        }
        return leftHit || rightHit;
    }
}
