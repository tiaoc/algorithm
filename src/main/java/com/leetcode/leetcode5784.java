package com.leetcode;

import java.util.HashMap;

public class leetcode5784 {
    public boolean makeEqual(String[] words) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(String word:words) {
            for (int i = 0; i < word.length(); i++) {
                map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0));
            }
        }
        System.out.println();
        for(Character c:map.keySet()){
            if(map.get(c)%words.length!=0){
                return false;
            }
        }
        return true;
    }

}
