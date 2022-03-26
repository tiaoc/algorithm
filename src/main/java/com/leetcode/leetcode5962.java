package com.leetcode;

import java.util.HashMap;

public class leetcode5962 {
    //找对称串，中间可以拼一个aa，这样的相同字符，且aa是单独出现的
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> resource = new HashMap<>();
        int coupleCount = 0;
        for (String s : words) {
            String s2 = s.substring(1) + s.substring(0, 1);
            if (resource.containsKey(s2)) {
                coupleCount++;
                int n = resource.get(s2);
                if (n == 1) {
                    resource.remove(s2);
                } else {
                    resource.put(s2, n - 1);
                }
            } else {
                resource.put(s, resource.getOrDefault(s, 0) + 1);
            }
        }
        int add = 0;
        for (String s : resource.keySet()) {
            if (s.charAt(0) == s.charAt(1)) {
                add = 2;
                break;
            }
        }
        return coupleCount * 4 + add;
    }
}
