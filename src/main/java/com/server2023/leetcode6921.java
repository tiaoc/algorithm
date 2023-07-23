package com.server2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode6921 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                if (w.charAt(i) == separator) {
                    if (sb.length() > 0) {
                        res.add(sb.toString());
                        sb = new StringBuilder();
                    }
                } else {
                    sb.append(w.charAt(i));
                }
                if (i == w.length() - 1 && sb.length() > 0) {
                    res.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "one.two.three";
        System.out.println(Arrays.toString(s.split("w")));
    }
}
