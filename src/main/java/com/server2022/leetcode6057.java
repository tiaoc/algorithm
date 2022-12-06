package com.server2022;

import com.base.TreeNode;

import java.util.Map;
import java.util.Stack;

public class leetcode6057 {
    //后序遍历，sum值和个数
//    public int averageOfSubtree(TreeNode root) {
//        TreeNode cur = root, pre = null;
//        Stack<TreeNode> stack = new Stack<>();
//        Map<>
//        while (cur != null || !stack.isEmpty()) {
//            while (cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop();
//            if (cur.right == null || cur.right == pre) {
//                pre = cur;
//                cur = null;
//
//            } else {
//                stack.push(cur);
//                cur = cur.right;
//            }
//        }
//    }
    public int averageOfSubtree(TreeNode root) {
        int[] v = order(root);
        return v[2];
    }

    public int[] order(TreeNode root) {
        int sum = 0, count = 0, res = 0;
        if (root.left != null) {
            int[] a = order(root.left);
            sum += a[0];
            count += a[1];
            res += a[2];
        }
        if (root.right != null) {
            int[] b = order(root.right);
            sum += b[0];
            count += b[1];
            res += b[2];
        }
        int add = 0;
        if (root.val == ((sum + root.val) / (count + 1))) {
            add = 1;
        }
        return new int[]{sum + root.val, count + 1, res + add};
    }
}
