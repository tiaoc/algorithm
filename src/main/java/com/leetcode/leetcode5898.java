package com.leetcode;

import java.util.HashMap;

public class leetcode5898 {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Boolean> map =new HashMap<>();
        for (String s: arr){
            if(map.containsKey(s)) {
                map.put(s, true);
            }else {
                map.put(s, false);
            }
        }
        for (String s: arr){
            if (!map.get(s)){
                k--;
                if(k==0){
                    return s;
                }
            }
        }
        return "";
    }
}
