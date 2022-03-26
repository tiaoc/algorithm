package com.leetcode;

import java.util.HashMap;
import java.util.HashMap;
import java.util.Stack;

public class leetcode5944 {
    //start和end节点,每个节点维护两个start和end是否存在于它的子树（或者具体到左子右子）
    //定位到两个节点的最小公共父节点
    //从start，找父节点，继续找父节点，直到找到公共父节点，然后向下找end节点
    //每个节点维护一个父节点的引用
    //dfsbfs？
    //如何维护，一个ListNode[n],HashMap
    public String getDirections(TreeNode root, int startValue, int destValue) {
        HashMap<Integer,String> startMap=new HashMap<>();
        HashMap<Integer,String> endMap=new HashMap<>();

        startMap.put(startValue,"");
        endMap.put(destValue,"");
        
        Stack<TreeNode> stack=new Stack<>();
        TreeNode pre =null, cur=root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            if(cur.right==null||cur.right==pre){//cur.right==pre，cur是pre的父节点，
                if(cur.left !=null && startMap.containsKey(cur.left.val)){
                    startMap.put(cur.val,"L");
                }
                if(cur.left !=null && endMap.containsKey(cur.left.val)){
                    endMap.put(cur.val,"L");
                }
                if(cur.right !=null && startMap.containsKey(cur.right.val)){
                    startMap.put(cur.val,"R");
                }
                if(cur.right !=null && endMap.containsKey(cur.right.val)){
                    endMap.put(cur.val,"R");
                }

                pre=cur;//pre是右子节点的父节点
                cur=null;
            }else{
                stack.push(cur);//cur再次入栈，遍历它的右子树，等到pre是它的右子节点时，它才能出去
                cur=cur.right;
            }
        }
        while(true) {
            if (root.left!=null && startMap.containsKey(root.left.val) && endMap.containsKey(root.left.val)) {
                root = root.left;
            } else if (root.right!=null && startMap.containsKey(root.right.val) && endMap.containsKey(root.right.val)) {
                root = root.right;
            }else{
                break;
            }
        }
        cur=root;
        StringBuilder sb=new StringBuilder();
        while(cur.val !=startValue){
            if(startMap.get(cur.val).equals("L")){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
            sb.append("U");
        }
        cur=root;
        while(cur.val !=destValue){
            if(endMap.get(cur.val).equals("L")){
                cur=cur.left;
                sb.append("L");
            }else{
                cur=cur.right;
                sb.append("R");
            }
        }
        return sb.toString();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
