package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class leetcode5918 {
    //连续
    //不允许跳过选择，那么只能加入或者开新的。
    //到了这个地方 判断，如果是+1，然后继续往下走
    public int countVowelSubstrings(String word) {
        int n = word.length();
        HashSet<Character> set = new HashSet<>();
        char[] vo = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < vo.length; i++) {
            set.add(vo[i]);
        }
        HashSet<Character> temp;
        HashMap<Character, Integer> map = new HashMap<>();
        int count=0;
        for (int i = 0; i < n; i++) {
            temp=new HashSet<>();
            for (int j = i; j < n; j++) {
                if (set.contains(word.charAt(j))) {
                    temp.add(word.charAt(j));
                    if(temp.size()==5){
                        count++;
                    }
                }else{
                    break;
                }
            }
        }
        return count;
    }
}
