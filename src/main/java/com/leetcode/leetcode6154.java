package com.leetcode;

import java.util.*;

public class leetcode6154 {
    public int amountOfTime(TreeNode root, int start) {
        Set<Integer> infected = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode s;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                if (root.val == start) {
                    s = root;
                }
                stack.push(root);
                map.put(root.left.val, root);
                root = root.left;
            }
            root = stack.pop();
            map.put(root.right.val, root);
            root = root.right;
        }
        Queue <TreeNode> q = new LinkedList<>();
        
        return 0;
    }
}
