package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode297 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args) {
        TreeNode a=new TreeNode(3);
        TreeNode b=new TreeNode(2);
        a.left=b;
        System.out.println(Codec.serialize(a));
    }
    public static class Codec {

        // Encodes a tree to a single string.
        public static String serialize(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (root != null) {
                queue.offer(root);
                sb.append(root.val).append(",");
            }else{
                return "";
            }
            while (!queue.isEmpty()) {
                Queue<TreeNode> temp = new LinkedList<>();
                while (!queue.isEmpty()) {
                    TreeNode cur = queue.poll();
                    if (cur != null) {
                        temp.offer(cur.left);
                        temp.offer(cur.right);
                        if (cur.left != null) {
                            sb.append(cur.left.val).append(",");
                        } else {
                            sb.append("null,");
                        }
                        if (cur.right != null) {
                            sb.append(cur.right.val).append(",");
                        } else {
                            sb.append("null,");
                        }
                    }
                }
                queue = temp;
            }
            sb.append(']');
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals("")){
                return null;
            }
            String[] dataList = data.substring(1,data.length()-1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(dataList[0]));
            Queue <TreeNode> queue =new LinkedList<>();
            queue.offer(root);
            int i=1;
            while(!queue.isEmpty()){
                TreeNode cur=queue.poll();
                if(!dataList[i].equals("null")){
                    cur.left= new TreeNode(Integer.parseInt(dataList[i]));
                    queue.offer(cur.left);
                }
                i++;
                if(!dataList[i].equals("null")){
                    cur.right= new TreeNode(Integer.parseInt(dataList[i]));
                    queue.offer(cur.right);
                }
                i++;
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
