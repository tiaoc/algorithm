package com.toOffer02;

import java.util.LinkedList;
import java.util.List;

public class code34 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private LinkedList<Integer> list = new LinkedList<>();
    private List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        help(root,sum);
        return result;

    }
    public void help(TreeNode node,int sum){
        if(node==null) return;
        list.add(node.val);
        sum-=node.val;
        if(sum==0&&node.left==null&&node.right==null){
            result.add(new LinkedList<>(list));
        }
        help(node.left,sum);
        help(node.right,sum);
        list.removeLast();
    }
}
