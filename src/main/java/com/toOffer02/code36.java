package com.toOffer02;

public class code36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    class Solution {
        Node pre,head;
        public Node treeToDoublyList(Node root) {
            if(root == null) return null;
            inorder(root);
            while(root.right!=null){
                root=root.right;
            }
            root.right=head;
            head.left=root;
            return head;
        }
        private void inorder(Node cur){
            if(cur==null)return;
            inorder(cur.left);

            if(pre==null) head=cur;
            else pre.right=cur;
            cur.left=pre;
            pre=cur;

            inorder(cur.right);
            return;
        }
    }
}


















