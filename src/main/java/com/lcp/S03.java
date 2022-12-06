package com.lcp;

import com.base.TreeNode;

import java.util.*;

public class S03 {
    //中序遍历，merge更改操作
    public int getNumber(TreeNode root, int[][] ops) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeNode head = root;
        for (int i= ops.length-1;i>=0;i--) {
            int[] op=ops[i];
            root = head;
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    if (root.val <= op[1]) {
                        break;
                    }
                    root = root.left;
                }
                if (stack.isEmpty()) {
                    break;
                }
                root = stack.pop();
                if (root.val >= op[1] && root.val <= op[2]) {
                    map.put(root.val, op[0]);
                } else if (root.val >= op[2]) {
                    break;
                }
                root = root.right;
            }
        }
        long count = map.entrySet().stream().filter(e->e.getValue()==1).count();
        return (int) count;
    }
}
