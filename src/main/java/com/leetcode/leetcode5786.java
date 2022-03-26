package com.leetcode;

import java.util.HashMap;

public class leetcode5786 {
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] strs=s.toCharArray();
        int left=0,right=removable.length-1;
        while(left<right){
            int mid=(left+right)/2;
            boolean[] flag=new boolean[strs.length];
            for(int i=0;i<=mid;i++){
                flag[removable[i]]=true;
            }
            int index=0;
            for(int j=0;j<strs.length;j++){
                if(!flag[j]&&strs[j]==p.charAt(index)){
                    index++;
                    if(index==p.length()){
                        break;
                    }
                }
            }
            if(index==p.length()){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
//    public int maximumRemovals(String s, String p, int[] removable) {
//        char[] strs=s.toCharArray();
//        int[] order=new int[strs.length];
//        int index=0;
//        HashMap<>()
//        for(int j=0;j<strs.length;j++){
//
//        }
//        return res;
//    }
}
