package com.leetcode;

import java.util.Arrays;

public class leetcode5952 {
    public static void main(String[] args) {
        System.out.println(countPoints("B0B6G0R6R0R6G9"));
    }
    public static int countPoints(String rings) {
        int[] status=new int[10];
        for(int i=0;i<rings.length();i++){
            char color =rings.charAt(i);
            int pos =rings.charAt(++i)-'0';
            switch (color){
                case 'R':
                    status[pos]|=1;
                    break;
                case 'G':
                    status[pos]|=(1<<1);
                    break;
                default:
                    status[pos]|=(1<<2);
            }
        }
        int res=0;
        for(int i=0;i<10;i++){
            if(status[i]==7){
                res++;
            }
        }
        return res;
    }
}
