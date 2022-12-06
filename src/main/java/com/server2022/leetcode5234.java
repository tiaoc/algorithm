package com.server2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode5234 {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (String s : words) {
            Map<Character, Integer> cur = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                cur.put(s.charAt(i), cur.getOrDefault(s.charAt(i), 0) + 1);
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
            }
            boolean f = false;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() != 0) {
                    f = true;
                    break;
                }
            }
            map = cur;
            if (f) {
                res.add(s);
            }
        }
        return res;
    }
}
