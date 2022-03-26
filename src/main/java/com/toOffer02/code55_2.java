package com.toOffer02;

public class code55_2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    // 由上到下计算每个节点的深度会造成重复计算，不推荐使用
//    public boolean isBalanced(TreeNode root) {
//        if(root==null) return true;
//        int dl=depth(root.left),dr=depth(root.right);
//        if(Math.abs(dl-dr)>1){
//            return false;
//        }
//        return isBalanced(root.left)&&isBalanced(root.right);
//    }
//    private static int depth(TreeNode root){
//        if(root==null) return  0;
//        return 1+Math.max(depth(root.left),depth(root.right));
//    }

    /*还是自下而上
    public boolean isBalanced(TreeNode root) {
        return func(root)!=-1;
    }
    private static int func(TreeNode root){
        if(root==null) return 0;
        int left,right;
        left=func(root.left);
        right=func(root.right);
        if(left==-1||right==-1) return -1;
        if(Math.abs(left-right)>1)return -1;
        else return Math.max(left,right)+1;
    }
     */
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(depth(root.left)-depth(root.right))>1){
            return false;
        }else {
            return isBalanced(root.left)&&isBalanced(root.right);
        }
    }
    private int depth(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(depth(root.left),depth(root.right));
    }
}
