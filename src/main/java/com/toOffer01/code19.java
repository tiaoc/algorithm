package com.toOffer01;

public class code19 {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));//f
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("mississippi", "mis*is*ip*."));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("ab",".*c"));//f
        System.out.println(isMatch("aaa","aaaa"));//f
    }
//leetcode 363 / 447
    public static boolean isMatch(String s, String p) {
        byte[] ss = s.getBytes();
        byte[] pattern = p.getBytes();
        if (ss.length == 0 && pattern.length == 0) return true;
        if (ss.length != 0 && pattern.length == 0) return false;
        int i = 0, j = 0;
        while (i < ss.length) {
            if (j >= pattern.length) return false;
            if (ss[i] == pattern[j] || pattern[j] == '.') {
                i++;
                j++;
            }else if (pattern[j] == '*') {
                if (ss[i] == ss[i - 1] || pattern[j - 1] == '.') {
                    i++;
                } else {
                    j++;
                }
            } else if (j<pattern.length-1) {
                if((ss[i]!=pattern[j]||pattern[j] != '.')&&pattern[j+1] == '*'){
                    j+=2;
                }else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if(j<pattern.length-1) {
            return false;
        }else return true;
    }
}
//"mississippi","mis*is*ip*."