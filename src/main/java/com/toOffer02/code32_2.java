package com.toOffer02;

import java.util.LinkedList;
import java.util.List;

public class code32_2 {
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
        LinkedList<TreeNode> tree = new LinkedList<>();
        int i = 1, j = 0;
        tree.add(root);
        while (!tree.isEmpty()) {
            if (tree.peek().left != null) {
                tree.add(tree.peek().left);
                j++;
            }
            if (tree.peek().right != null) {
                tree.add(tree.peek().right);
                j++;
            }
            list.add(tree.pop().val);//pop-poll
            i--;
            if (i == 0) {
                result.add(list);
                list = new LinkedList<>();
                i = j;
                j = 0;
            }
        }
        return result;
    }
}
