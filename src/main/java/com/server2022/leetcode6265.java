package com.server2022;

import java.util.HashMap;
import java.util.Map;

public class leetcode6265 {
    public static void main(String[] args) {
        String[] v = new String[]{"dcedceadceceaeddcedc", "dddcebcedcdbaeaaaeab", "eecbeddbddeadcbbbdbb", "decbcbebbddceacdeadd", "ccbddbaedcadedbcaaae", "dddcaadaceaedcdceedd", "bbeddbcbbccddcaceeea", "bdabacbbdadabbbddaea"};
        System.out.println(similarPairs(v));
    }

    public static int similarPairs(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String w : words) {
            boolean[] temp = new boolean[26];
            for (char c : w.toCharArray()) {
                temp[c - 'a'] = true;
            }
            int v = 0;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i]) {
                    v |= 1 << i;
                }
            }
            map.putIfAbsent(v, 0);
            map.put(v, map.get(v) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            count += v * (v - 1) / 2;
        }
        return count;
    }

}
