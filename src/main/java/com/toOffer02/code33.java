package com.toOffer02;

public class code33 {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length==0) return true;
        return recur(postorder,0,postorder.length-1);
    }
    public static boolean recur(int[] postorder,int start,int end){
        if(start==end) return true;
        int i;
        for(i=start;i<end;i++){
            if(postorder[i]>postorder[end])
                break;
        }
        for(;i<end;i++){
            if(postorder[i]<postorder[end]){
                return false;
            }
        }
        if(recur(postorder,start,i-1)&&recur(postorder,i,end)){
            return true;
        }
        return false;
    }
}
