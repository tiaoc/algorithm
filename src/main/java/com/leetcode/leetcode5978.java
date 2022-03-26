package com.leetcode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeMap;

public class leetcode5978 {
    //字符个数，重复后个数，将字符散列？
    //首先满足个数-1.
    //然后看有没有出现target之外的字符
    //然后看是不是只有一个字符没有命中（考虑重复字符）
    //全部按字典序重排
    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<String> set =new HashSet<>();
        int res=0;
        for (String s:startWords){
            set.add(reSort(s).toString());
        }
        for (String s : targetWords) {
            StringBuilder t2 = reSort(s);
            for (int i=0;i<t2.length();i++) {
                char cur = t2.charAt(i);
                if (set.contains(t2.deleteCharAt(i).toString())){
                    res ++;
                    break;
                }
                t2.insert(i,cur);
            }
        }
        return res;
    }
    private StringBuilder reSort(String s) {
        TreeMap<Character,Integer> map =new TreeMap<>(Comparator.comparingInt(o -> o));
        for (int i=0;i<s.length();i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0));
        }
        StringBuilder sb =new StringBuilder();
        for (Character c :map.keySet()){
            sb.append(c);
        }
        return sb;
    }
}
