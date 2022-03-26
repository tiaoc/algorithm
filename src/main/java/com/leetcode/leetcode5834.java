package com.leetcode;

public class leetcode5834 {
    //保证顺序和逆序最短，26个字母，0-25，0-1，0-2，0-12，左13，13-25，右13，+12为顺序，-12为逆序，比较end-start比12大还是小，小于等于12，顺序增加
    //大于12， 26-（end-start）
    public int minTimeToType(String word) {
        char c='a';
        int res=0;
        for(int i=0;i<word.length();i++){
            if((word.charAt(i)+26-c)%26>12){
                res+=26-(word.charAt(i)+26-c)%26;
            }else{
                res+=(word.charAt(i)+26-c)%26;
            }
            res++;
            c=word.charAt(i);
        }
        return res;
    }
}
