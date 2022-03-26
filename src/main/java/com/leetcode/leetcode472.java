package com.leetcode;

import java.util.*;

public class leetcode472 {
    public static void main(String[] args) {
        String[] words = new String[]{"cat", "cats", "catsdogcats",
                "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        System.out.println(new leetcode472().findAllConcatenatedWordsInADict(words));
    }

    //在字典树中深度优先搜索
    // ab bc
    Trie trie = new Trie();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 0) {
                continue;
            }
            if (dfs(words[i], 0)) {
                ans.add(words[i]);
            } else {
                insert(words[i]);
            }
        }
        return ans;
    }

    public boolean dfs(String word, int start) {
        if (start == word.length()) {
            return true;
        }
        Trie node = trie;
        for (int i = start; i < word.length(); i++) {
            int cur = word.charAt(i) - 'a';
            node = node.children[cur];
            if (node == null) {
                return false;
            } else if (node.isEnd) {
                // node在这个点end，分一个分支出去，不代表后面就不能匹配了，一直要走到当前start的最后一个end
                if (dfs(word, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void insert(String word) {
        Trie node = trie;
        for (int i = 0; i < word.length(); i++) {
            int cur = word.charAt(i) - 'a';
            //不能破坏原先的结构，只应该添加子
            if (node.children[cur] == null) {
                node.children[cur] = new Trie();
            }
            node = node.children[cur];
        }
        node.isEnd = true;
    }

    class Trie {
        Trie[] children;
        boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }
    }
}
