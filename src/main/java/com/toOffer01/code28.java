package com.toOffer01;

public class code28 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        //构造相反的遍历
        if(root==null) return true;
        return func(root.left,root.right);
    }
    public boolean func(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        if(left.val!=right.val){
            return false;
        }
        return func(left.left,right.right)&&func(left.right,right.left);
    }
}
