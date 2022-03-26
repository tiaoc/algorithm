package com.toOffer01;

public class code27 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        mirrorTree(root.left);
        mirrorTree(root.right);
        TreeNode temp;
        temp=root.left;
        root.left=root.right;
        root.right=temp;
        return root;
    }
}
