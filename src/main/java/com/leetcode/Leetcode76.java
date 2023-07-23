package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Leetcode76 {
    public static void main(String[] args) {

        System.out.println(new Leetcode76().minWindow("acbbaca", "aba"));
    }

    // 最小子串
    // 某个字符开始，某个字符结束
    // 滑动窗口？ 从某个地方开始记录某个字符，要开n个窗口吗？
    // n个字符的窗口的重叠部分。不可，多个重复字符要都含有
    // dfs不行，dp？字符+次数 状态如果转移 填充要求，start和end在变。
    // 字母和其个数要求
    public String minWindow(String s, String t) {
        int st = 0, end = s.length(), minLen = Integer.MAX_VALUE, fill = 0;
        int[] count = new int[58];
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'A']++;
        }
        for (int j = 0; j < 58; j++) {
            if (count[j] == 0) {
                count[j] = -1;
            }
        }
        List<Integer>[] lastIdx = new List[58];
        for (int i = 0; i < lastIdx.length; i++) {
            lastIdx[i] = new LinkedList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int cur = c - 'A';
            if (count[cur] > 0) {
                count[cur]--;
                lastIdx[cur].add(i);
                fill++;
            } else if (count[cur] == 0) {
                lastIdx[cur].remove(0);
                lastIdx[cur].add(i);
            }
            if (count[cur] < 0 || fill != t.length()) {
                continue;
            }
            int start = lastIdx[cur].get(0);
            for (int j = 0; j < 58; j++) {
                if (!lastIdx[j].isEmpty()) {
                    start = Math.min(start, lastIdx[j].get(0));
                }
            }
            if (i - start + 1 < minLen) {
                minLen = i - start + 1;
                st = start;
                end = i + 1;
            }
        }
        if (fill == t.length()) {
            return s.substring(st, end);
        }
        return "";
    }
}
