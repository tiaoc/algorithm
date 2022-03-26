package com.toOffer02;

public class code48 {
    public static void main(String[] args) {
        String str="abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int i=0,j=1,count=1;
        while(j<s.length()){
            for(int k=i;k<j;k++) {
                if (s.charAt(k) == s.charAt(j)){
                    i = k+1;
                    break;
                }
            }
            if (j - i + 1 > count) {
                count = j - i + 1;
            }
            j++;
        }
        return count;
    }
}
