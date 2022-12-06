package com.server2022;

public class leetcode6108 {
    public String decodeMessage(String key, String message) {
        boolean[] visited = new boolean[26];
        char[] project = key.toCharArray();
        char[] secret = new char[26];
        int idx = 0;
        for (int i = 0; i < project.length; i++) {
            if (project[i] - 'a' >= 0 && project[i] - 'a' < 26 && !visited[project[i] - 'a']) {
                visited[project[i] - 'a'] = true;
                secret[idx++] = project[i];
            }
        }
        char[] code = new char[26];
        for (int i = 0; i < 26; i++) {
            code[secret[i] - 'a'] = (char) (i + 'a');
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) - 'a' >= 0 && message.charAt(i) - 'a' < 26) {
                res.append(code[message.charAt(i) - 'a']);
            } else {
                res.append(message.charAt(i));
            }
        }
        return res.toString();
    }
}
