package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode6018 {
    // 两个节点用一个边 n个边有n-1个节点
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> edgeSet = new HashSet<>();
        for (int[] edge : descriptions) {
            edgeSet.add(edge[1]);
            nodes.computeIfAbsent(edge[1], node -> new TreeNode(edge[1], null, null));
            TreeNode node = nodes.get(edge[1]);
            if (nodes.containsKey(edge[0])) {
                if (edge[2] == 1) {
                    nodes.get(edge[0]).left = node;
                } else {
                    nodes.get(edge[0]).right = node;
                }
            } else {
                if (edge[2] == 1) {
                    nodes.put(edge[0], new TreeNode(edge[0], node, null));
                } else {
                    nodes.put(edge[0], new TreeNode(edge[0], null, node));
                }
            }
        }
        for (Map.Entry<Integer, TreeNode> entry : nodes.entrySet()) {
            if (!edgeSet.contains(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }
}
