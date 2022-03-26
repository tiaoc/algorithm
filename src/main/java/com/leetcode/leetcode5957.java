package com.leetcode;

public class leetcode5957 {
    public String addSpaces(String s, int[] spaces) {
        int len=s.length()+spaces.length;
        int i=0,j=0;
        StringBuilder sb = new StringBuilder();
        while(true){
            if(j<spaces.length) {
                sb.append(s, i, spaces[j]);
                sb.append(" ");
                i=spaces[j];
                j++;
            }else{
                sb.append(s,i,s.length());
                break;
            }
        }
        return sb.toString();
    }
}
