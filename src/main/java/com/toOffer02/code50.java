package com.toOffer02;

import java.util.HashMap;

public class code50 {
    public char firstUniqChar(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int i=0;
        while(i<s.length()){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),0);
            }
            i++;
        }
        i=0;
        while(i<s.length()){
            if(map.get(s.charAt(i))==1){
                return s.charAt(i);
            }
            i++;
        }
        return ' ';
    }
}
