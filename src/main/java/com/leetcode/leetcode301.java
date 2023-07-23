package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode301 {
    // 所有可能的结果
    // 栈,成对，入栈出栈
    //
    public static void main(String[] args) {
        System.out.println(new leetcode301().removeInvalidParentheses("()())()"));
    }

    private List<String> res = new ArrayList<String>();

    public List<String> removeInvalidParentheses(String s) {
        int lremove = 0;
        int rremove = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lremove++;
            } else if (s.charAt(i) == ')') {
                if (lremove > 0) {
                    lremove--;
                } else {
                    rremove++;
                }
            }
        }
        dfs(0, s, lremove, rremove);
        return res;
    }

    private void dfs(int cur, String s, int lremove, int rremove) {
        if (lremove == 0 && rremove == 0) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    count++;
                } else if (s.charAt(i) == ')') {
                    count--;
                }
                if (count < 0) {
                    return;
                }
            }
            res.add(s);
            return;
        }
        for (int i = cur; i < s.length(); i++) {
            if (i != cur && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (lremove > 0 && s.charAt(i) == '(') {
                dfs(i, s.substring(0, i) + s.substring(i + 1), lremove - 1, rremove);
            }
            if (rremove > 0 && s.charAt(i) == ')') {
                dfs(i, s.substring(0, i) + s.substring(i + 1), lremove, rremove - 1);
            }
        }
    }
}
