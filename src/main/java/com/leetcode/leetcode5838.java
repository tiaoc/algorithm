package com.leetcode;

public class leetcode5838 {
    public static void main(String[] args) {
        String s="iloveleetcode";
        String[] sc= new String[]{"i", "love", "leetcode", "apples"};
        System.out.println(isPrefixString(s,sc));
    }
    public static boolean isPrefixString(String s, String[] words) {
        int idx=0;
        for(int i=0;i<words.length;i++){
            if(idx==s.length()){
                break;
            }
            if(idx+words[i].length()>s.length()){
                return false;
            }
            if(words[i].equals(s.substring(idx,idx+words[i].length()))){
                idx+=words[i].length();
            }else{
                return false;
            }
        }
        if(idx==s.length()){
            return true;
        }
        return false;
    }
}
