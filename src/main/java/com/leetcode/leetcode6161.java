package com.leetcode;

import java.util.Stack;

public class leetcode6161 {
    public String removeStars(String s) {
        char[] cs = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[cs.length];
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '*') {
                int idx = stack.pop();
                visited[idx] = true;
                visited[i] = true;
            } else {
                stack.push(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                sb.append(cs[i]);
            }
        }
        return sb.toString();
    }
}
