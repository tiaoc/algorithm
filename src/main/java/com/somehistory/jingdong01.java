package com.somehistory;

import java.util.LinkedList;

public class jingdong01 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    static LinkedList<TreeNode> list=new LinkedList<>();

    public static void main(String[] args) {
        TreeNode root=new TreeNode();
        root.left=new TreeNode();
    }
    private static void func(TreeNode root){
        if(root==null){

        }
        list.add(root.left);
        list.add(root.right);
        list.pop();
        func(list.pop());
    }
}
