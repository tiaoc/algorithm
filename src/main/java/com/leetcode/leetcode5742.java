package com.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class leetcode5742 {
    public static void main(String[] args) {
        String s="is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
    }
    public static String sortSentence(String s) {
        StringBuilder sb=new StringBuilder();
        TreeMap<Integer,String> map=new TreeMap<>();
        int i=0;
        while(i<s.length()){
            int left=i;
            while(i!=s.length()&&s.charAt(i)!=' '){
                i++;
            }
            map.put(s.charAt(i-1)-'0',s.substring(left,i-1));
            i++;
        }
        while(!map.isEmpty()){
            Map.Entry<Integer,String> cur=map.pollFirstEntry();
            sb.append(cur.getValue());
            if(map.size()>0) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
