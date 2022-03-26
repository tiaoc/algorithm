package com.leetcode;

public class leetcode474 {
    public static void main(String[] args) {
        String[] strs={"10","0001","111001","1","0"};
        System.out.println(findMaxForm(strs,5,3));
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        int res=0;
        for(String s:strs){
            int count=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0'){
                    count++;
                }
            }
            if(count<=m&&s.length()-count<=n){
                res++;
            }
        }
        return res;
    }
}
