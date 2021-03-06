package com.leetcode;

import java.util.Stack;

public class leetcode230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack =new Stack<>();
        int count=0;
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            count++;
            if(count==k){
                return root.val;
            }
            root=root.right;
        }
        return 0;
    }
}
