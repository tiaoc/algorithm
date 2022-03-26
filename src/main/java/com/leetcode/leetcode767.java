package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode767 {
    public String reorganizeString(String S) {
        if(S.length()<2){
            return S;
        }
        char[] chars=S.toCharArray();
        int[] counts=new int[26];
        int maxcount=0;
        for(char c:chars){
            counts[c-'a']++;
            maxcount=Math.max(counts[c-'a'],maxcount);
        }
        if(maxcount>(S.length()+1)/2){
            return "";
        }
        PriorityQueue<Character> queue=new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return counts[o2-'a']-counts[o1-'a'];
            }
        });
        for(char c='a';c<='z';c++){
            if(counts[c-'a']>0){
                queue.offer(c);
            }
        }
        StringBuffer buffer=new StringBuffer();
        while(queue.size()>1){
            char letter1=queue.poll();
            char letter2=queue.poll();
            buffer.append(letter1);
            buffer.append(letter2);
            if(--counts[letter1-'a']>0){
                queue.offer(letter1);
            }
            if(--counts[letter2-'a']>0){
                queue.offer(letter2);
            }
        }
        if(queue.size()==1){
            buffer.append(queue.poll());
        }
        return buffer.toString();
    }
}










