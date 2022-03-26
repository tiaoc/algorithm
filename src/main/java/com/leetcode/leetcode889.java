package com.leetcode;

public class leetcode889 {
    public static void main(String[] args) {
        leetcode889 d=new leetcode889();
        int[] pre = {1,2,4,5,3,6,7}, post = {4,5,2,6,7,3,1};
        System.out.println(d.constructFromPrePost(pre,post));
    }
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n=pre.length;
        return construct(pre,post,0,0,n);
    }
    private TreeNode construct(int[] pre,int[] post,int pre_left,int post_left,int len){
        if(len==0){
            return null;
        }
        TreeNode cur=new TreeNode(pre[pre_left]);
        if(len==1){
            return cur;
        }
        int mid=0;
        for(int i=post_left;i<post_left+len;i++){
            if(pre[pre_left+1]==post[i]){
                mid=i;
                break;
            }
        }
        int newLen=mid-post_left+1;
        cur.left=construct(pre,post,pre_left+1,post_left,newLen);
        cur.right=construct(pre,post,pre_left+newLen+1,post_left+newLen,len-newLen-1);
        return cur;
    }
}
