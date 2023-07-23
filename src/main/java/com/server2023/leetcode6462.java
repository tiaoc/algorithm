package com.server2023;

import java.util.HashSet;
import java.util.Set;

public class leetcode6462 {
    public int minimizedStringLength(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set.size();
    }
}
