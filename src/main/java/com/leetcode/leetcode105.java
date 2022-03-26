package com.leetcode;

import java.util.HashMap;

public class leetcode105 {
    public static void main(String[] args) {
        int[] preOrder={3,9,20,15,7};
        int[] inOrder={9,3,15,20,7};
        System.out.println(buildTree(preOrder,inOrder));
    }
    static HashMap<Integer,Integer> map;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<>();
        int n=inorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,0,n,inorder,0,n);
    }
    private static TreeNode build(int[] preorder,int preLeft,int preRight, int[] inorder,int inLeft,int inRight){
        if(preRight<=preLeft){
            return null;
        }
        TreeNode cur=new TreeNode(preorder[preLeft]);
        int inStart=map.get(preorder[preLeft]);
        int len=inStart-inLeft;
        cur.left=build(preorder,preLeft+1,preLeft+len+1,inorder,inLeft,inStart);
        cur.right=build(preorder,preLeft+len+1,preRight,inorder,inStart+1,inRight);
        return cur;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
