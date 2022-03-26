package com.toOffer02;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class code32_3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> tree = new Stack<>();
        Stack<TreeNode> tree2 = new Stack<>();
        boolean s=true;
        tree.add(root);
        while (!tree.isEmpty()) {
            if(s) {
                if (tree.peek().left != null) {
                    tree2.push(tree.peek().left);
                }
                if (tree.peek().right != null) {
                    tree2.push(tree.peek().right);
                }
            }else {
                if (tree.peek().right != null) {
                    tree2.push(tree.peek().right);
                }
                if (tree.peek().left != null) {
                    tree2.push(tree.peek().left);
                }
            }
            list.add(tree.pop().val);//pop-poll

            if (tree.empty()) {
                result.add(list);
                list = new LinkedList<>();
                tree=tree2;
                tree2=new Stack<>();
                s=!s;
            }
        }
        return result;
    }
}
