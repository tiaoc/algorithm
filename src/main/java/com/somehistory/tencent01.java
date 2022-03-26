package com.somehistory;

public class tencent01 {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int v){
            val=v;
        }
    }
    private void func(TreeNode root){
        if(root==null){
            return;
        }
        func(root.left);
        func(root.right);
        System.out.println(root.val);
    }
//    private void func2(TreeNode root){
//        TreeNode temp;
//        while (){
//
//        }
//    }
}
