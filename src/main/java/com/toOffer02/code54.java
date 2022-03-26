package com.toOffer02;

public class code54 {
    static int k;
    static int result;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthLargest(TreeNode root, int k) {
        //深度优先，个数累加
        this.k=k;
        func(root);
        return result;
    }
    private void func(TreeNode root){
        if(root==null) return;
        func(root.right);
        k--;
        if(k==0){
            result=root.val;
            return;
        }
        func(root.left);
    }
}
