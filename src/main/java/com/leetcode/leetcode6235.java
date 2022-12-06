package com.leetcode;

import java.util.*;

public class leetcode6235 {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        if (root == null) return 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            Map<Integer, Integer> level = new HashMap<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                level.put(node.val, i);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ArrayList<Integer> sorted = new ArrayList<>(list);
            sorted.sort(Comparator.comparingInt(a -> a));
            for (int i = 0; i < list.size(); i++) {
                int changeNum = sorted.get(i);
                int changeIdx = level.get(changeNum);
                if (changeNum == list.get(i)) {
                    continue;
                }
                level.put(list.get(i), changeIdx);
                list.set(changeIdx, list.get(i));
                count++;
            }
        }
        return count;
    }
}
