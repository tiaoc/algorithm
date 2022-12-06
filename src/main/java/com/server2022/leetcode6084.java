package com.server2022;

import java.util.HashMap;
import java.util.Map;

public class leetcode6084 {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            int count = messages[i].split(" ").length;
            map.put(senders[i], map.getOrDefault(senders[i], 0) + count);
        }
        String v = "";
        int count = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > count || e.getValue() == count && e.getKey().compareTo(v) > 0) {
                v = e.getKey();
                count = e.getValue();
            }
        }
        return v;
    }
}
