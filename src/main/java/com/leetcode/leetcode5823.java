package com.leetcode;

public class leetcode5823 {
    public int getLucky(String s, int k) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i)-'a'+1);
        }
        System.out.println(sb);
        int lastRes=0;
        for(int j=0;j<sb.length();j++){
            lastRes+=sb.charAt(j);
        }
        for(int i=1;i<k;i++){
            int temp=0;
            while(lastRes>0){
                temp+=(lastRes%10);
                lastRes/=10;
            }
            lastRes=temp;
        }
        return lastRes;
    }
}
