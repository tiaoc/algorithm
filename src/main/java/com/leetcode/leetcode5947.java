package com.leetcode;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class leetcode5947 {
    HashSet<String> set = new HashSet<>();
    HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String[] recipes =  new String[]{"ju","fzjnm","x","e","zpmcz","h","q"};

        List<List<String>> ingredients = Arrays.asList(Arrays.asList("d"),Arrays.asList("hveml","f","cpivl"),
                Arrays.asList("cpivl","zpmcz","h","e","fzjnm","ju"),Arrays.asList("cpivl","hveml","zpmcz","ju","h"),
                Arrays.asList("h","fzjnm","e","q","x"),Arrays.asList("d","hveml","cpivl","q","zpmcz","ju","e","x"),
                Arrays.asList("f","hveml","cpivl"));

        String[] supplies = new String[]{"f","hveml","cpivl","d"};
        System.out.println(new leetcode5947().findAllRecipes(recipes,ingredients,supplies));
    }
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int[] visited = new int[recipes.length];
        set.addAll(Arrays.asList(supplies));
        for (int i = 0; i < recipes.length; i++) {
            map.put(recipes[i], i);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < recipes.length; i++) {
            if (visited[i] == 0) {
                visited [i] = -1;
                dfs(i, ingredients, visited);
            }
            if (visited[i] == 1) {
                res.add(recipes[i]);
            }
        }
        return res;
    }

    private void dfs(int cur, List<List<String>> ingredients, int[] visited) {

        for (String s : ingredients.get(cur)) {
            if (!set.contains(s)) {
                if (map.containsKey(s) && visited[map.get(s)] == 0) {
                    visited[map.get(s)] = -1;
                    dfs(map.get(s), ingredients, visited);
                }
                if (!map.containsKey(s) || visited[map.get(s)] != 1) {
                    visited[cur] = -1;
                    return;
                }
            }
        }
        visited[cur] = 1;
    }
}
