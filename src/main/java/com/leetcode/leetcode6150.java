package com.leetcode;

public class leetcode6150 {
    /**
     * 上升要给下降留出空间
     *
     * @param pattern
     * @return
     */
    public static void main(String[] args) {
        System.out.println(new leetcode6150().smallestNumber("IIIDIDDD"));
    }
    String res = "";

    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            sb.append(i + 1);
            visited[i] = true;
            dfs(sb, visited, 0, pattern);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
        return res;
    }

    private void dfs(StringBuilder sb, boolean[] visited, int cur, String pattern) {
        if (cur == pattern.length()) {
            if (res.length() != 0) {
                res = sb.toString().compareTo(res) < 0 ? sb.toString() : res;
            } else {
                res = sb.toString();
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (pattern.charAt(cur) == 'I') {
                if (i <= sb.charAt(sb.length() - 1) - '1' || visited[i]) {
                    continue;
                }
            } else {
                if (i >= sb.charAt(sb.length() - 1) - '1' || visited[i]) {
                    continue;
                }
            }
            sb.append(i + 1);
            visited[i] = true;
            dfs(sb, visited, cur + 1, pattern);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
}
