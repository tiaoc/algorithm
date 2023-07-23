package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode438 {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pattern = new HashMap<>();
        int[] window = new int[26];
        for (char c : p.toCharArray()) {
            pattern.put(c, pattern.getOrDefault(c, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            // 右端点移动及其更新,right是右开区间,c是最右边的字符
            right++;
            if (pattern.containsKey(c)) {
                window[c - 'a']++;
                if (window[c - 'a'] == pattern.get(c)) {
                    valid++;
                }
            }
            // while循环中移动左端点及其更新， 注意这里的right是右开区间，实际idx是right-1
            // 确定左端点收缩的条件,这里只要满足valid就能满足长度限制。
            while (right - left >= p.length()) {
                if (valid == pattern.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (pattern.containsKey(d)) {
                    if (window[d - 'a'] == pattern.get(d)) {
                        valid--;
                    }
                    window[d - 'a']--;
                }
            }
        }
        return res;
    }

    // p数组每个字母都是0.
    public List<Integer> findAnagrams2(String s, String p) {
        int[] arr = new int[26];
        for (char c : p.toCharArray()) {
            arr[c - 'a']--;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char newChar = s.charAt(i);
            arr[newChar - 'a']++;
            if (i >= p.length()) {
                arr[s.charAt(i - p.length()) - 'a']--;
            }
            boolean f = true;
            for (int v : arr) {
                if (v != 0) {
                    f = false;
                    break;
                }
            }
            if (f) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}
