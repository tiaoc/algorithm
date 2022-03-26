package com.toOffer01;

public class code26 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSubStructure(TreeNode a, TreeNode b) {
        return (a!=null&&b!=null)&&(hashead(a,b)||isSubStructure(a.left,b)||isSubStructure(a.right,b));
    }
    public boolean hashead(TreeNode a,TreeNode b){
        if (b==null){
            return true;
        }
        if(a==null||a.val!=b.val){
            return false;
        }
        return hashead(a.left,b.left)&&hashead(a.right,b.right);
    }
}
