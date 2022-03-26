package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class leetcode402 {
    public static void main(String[] args) {
        String num="1432219";
        int k=3;
        System.out.println(removeKdigits(num,k));
    }
    public static String removeKdigits(String num, int k) {
        Deque<Integer> deque=new LinkedList<>();
        int i=0;
        while(i<num.length()){
            int temp=num.charAt(i)-'0';
            while(k>0&&!deque.isEmpty()&& deque.peekLast()>temp){
                deque.pollLast();
                k--;
            }
            deque.offerLast(temp);
            i++;
        }
        for(int j=0;j<k;j++){
            deque.pollLast();
        }
        StringBuilder s = new StringBuilder();
        while(!deque.isEmpty()){
            if(s.length()==0&&deque.peekFirst()==0){
                deque.pollFirst();
                continue;
            }
            s.append(deque.pollFirst());
        }
        return s.length()==0?"0":s.toString();
    }
}
