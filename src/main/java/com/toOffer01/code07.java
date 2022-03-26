package com.toOffer01;

import java.util.Arrays;

public class code07 {
    public static void main(String[] args) {
        int[] pre = {1, 2, 3, 4};
        int[] in = {4, 3, 2, 1};
        TreeNode a = reConstructBinaryTree(pre, in);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode tree = new TreeNode(pre[0]);
        int index=0;
        while(in[index]!=pre[0]){
            index++;
        }

        int[] in1 = Arrays.copyOfRange(in, 0, index);
        int[] in2 = Arrays.copyOfRange(in, index + 1, in.length);

        int[] pre1 = Arrays.copyOfRange(pre, 1, index + 1);
        int[] pre2 = Arrays.copyOfRange(pre, index + 1, pre.length);
        if (in1.length > 0) {
            tree.left = reConstructBinaryTree(pre1, in1);
        }
        if (in2.length > 0) {
            tree.right = reConstructBinaryTree(pre2, in2);
        }
        return tree;
    }
}
