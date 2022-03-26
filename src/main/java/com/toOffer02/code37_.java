package com.toOffer02;

import java.util.LinkedList;

public class code37_ {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null) return "[]";
            StringBuilder stringBuilder = new StringBuilder();
            LinkedList<String> linkedList = new LinkedList<>();
            if(root.left!=null){
                linkedList.add(root.left.val+",");
                linkedList.add(serialize(root.left));
            }else {
                linkedList.add("null,");
            }
            if(root.right!=null){
                linkedList.add(root.right.val+",");
                linkedList.add(serialize(root.right));
            }else {
                linkedList.add("null,");
            }
            return linkedList.toString();
        }
        // Decodes your encoded data to tree.
//        public TreeNode deserialize(String data) {
//
//        }
    }
}
