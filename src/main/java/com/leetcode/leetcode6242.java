package com.leetcode;

import java.util.*;

public class leetcode6242 {
    //二分查找边界
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < queries.size(); i++) {
            res.add(Arrays.asList(-1, -1));
            map.put(queries.get(i), i);
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                int a = list.get(0);
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int q = entry.getKey();
                    if (q < a) {
                        res.get(entry.getValue()).set(0, -1);
                        res.get(entry.getValue()).set(1, a);
                    }
                }
            }
            if (i == list.size() - 1) {
                int a = list.get(list.size() - 1);
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int q = entry.getKey();
                    if (q > a) {
                        res.get(entry.getValue()).set(0, a);
                        res.get(entry.getValue()).set(1, -1);
                    }
                }
            }else {
                int a = list.get(i);
                int b = list.get(i + 1);
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int q = entry.getKey();
                    if (q == a) {
                        res.get(entry.getValue()).set(0, a);
                        res.get(entry.getValue()).set(1, a);
                    }
                    if (q < b && q > a) {
                        res.get(entry.getValue()).set(0, a);
                        res.get(entry.getValue()).set(1, b);
                    }
                }
            }
        }
        return res;
    }
}
