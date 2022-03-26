package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode5804 {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int val=-1;
        for(Map.Entry entry:map.entrySet()){
            if(val==-1){
                val= (int) entry.getValue();
            }else if(val!=(int)entry.getValue()){
                return false;
            }
        }
        return true;
    }
}
