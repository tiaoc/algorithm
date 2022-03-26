package com.leetcode;

public class Leetcode5740 {
    public int longestBeautifulSubstring(String word) {
        char cur=word.charAt(0);
        int res=0;
        int len=0;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)=='a'){
                if(cur=='a'){
                    len++;
                }else{
                    cur='a';
                    len=1;
                }
            }else if(word.charAt(i)=='e'){
                if(cur=='a'||cur=='e'){
                    cur='e';
                    len++;
                }else{
                    cur='0';
                }
            }else if(word.charAt(i)=='i'){
                if(cur=='e'||cur=='i'){
                    cur='i';
                    len++;
                }else{
                    cur='0';
                }
            }else if(word.charAt(i)=='o'){
                if(cur=='i'||cur=='o'){
                    cur='o';
                    len++;
                }else{
                    cur='0';
                }
            }else if(word.charAt(i)=='u'){
                if(cur=='o'||cur=='u'){
                    cur='u';
                    len++;
                    res=Math.max(len,res);
                }else{
                    cur='0';
                }
            }
        }
        return res;
    }
}
