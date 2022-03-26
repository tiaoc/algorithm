package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode114 {
    //中序,入列
    //左子在中后进入，右在左后，那么就是中序遍历
    public static void main(String[] args) {
        TreeNode a=new TreeNode(1);
        TreeNode b=new TreeNode(2);
        TreeNode c=new TreeNode(3);
        a.left=b;
        b.right=c;
        leetcode114 aa=new leetcode114();
        aa.flatten(a);
        System.out.println(a.val);
        System.out.println(a.right.val);
        System.out.println(a.right.right.val);
    }
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode head=root;
        List<TreeNode> list=new ArrayList<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                list.add(root);
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            root=root.right;
        }
        for(int i=1;i<list.size();i++){
            head.left=null;
            head.right=list.get(i);
            head=head.right;
        }
    }
    public void flatten2(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode head=root,cur=new TreeNode(0);
        while(root!=null){
            if(root.left!=null){
                root=root.right;
            }else{
                TreeNode pre= root.left;
                while(pre.right!=null){
                    pre=pre.right;
                }
                pre.right=root.right;
                root.right=root.left;
                root.left=null;
                root=root.right;
            }
        }
    }
}
