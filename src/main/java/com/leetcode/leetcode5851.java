package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class leetcode5851 {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int n=nums[0].length();
        for(String s:nums){
            int cur=0,i=0;
            while(i<n-1){
                cur|=s.charAt(i)-'0';
                cur=cur<<1;
                i++;
            }
            cur|=s.charAt(i)-'0';
            set.add(cur);
        }
        System.out.println(set);
        for(int i=0;i<n;i++){
            if(!set.contains(i)){
                return getRes(i,n);
            }
        }
        return getRes(n,n);
    }
    private static String getRes(int val,int n){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(val%2==0){
                sb.append('0');
            }else{
                sb.append('1');
            }
            val/=2;
        }
        return sb.reverse().toString();
    }
}
