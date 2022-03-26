package com.leetcode;

import java.util.LinkedList;

public class leetcode649 {
    public static void main(String[] args) {
        String str="RDD";
        System.out.println(predictPartyVictory(str));
    }
    public static String predictPartyVictory(String senate) {
        LinkedList<Integer> radi=new LinkedList<>();
        LinkedList<Integer> dire=new LinkedList<>();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R'){
                radi.add(i);
            }else{
                dire.add(i);
            }
        }
        while(!radi.isEmpty()&&!dire.isEmpty()){
            int curr=radi.pollFirst();
            int curd=dire.pollFirst();
            if(curr<curd){
                radi.add(curr+senate.length());
            }else{
                dire.add(curd+senate.length());
            }
        }
        if(radi.isEmpty()){
            return "Dire";
        }else{
            return "Radiant";
        }
    }
}
