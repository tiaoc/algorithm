package com.leetcode;

public class leetcode5890 {
    public int minimumMoves(String s) {
        char[] strs=s.toCharArray();
        int count=0;
        for (int i=0;i<strs.length;i++){
            if (strs[i]=='X'){
                count++;
                i+=2;
            }
        }
        return count;
    }
}
