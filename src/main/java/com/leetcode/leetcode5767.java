package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeMap;

public class leetcode5767 {
    public boolean isCovered(int[][] ranges, int left, int right) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        HashSet<Integer> set=new HashSet<>();
        for(int[] pair:ranges) {
            for(int i=pair[0];i<=pair[1];i++){
                set.add(i);
            }
        }
        for(int i=left;i<=right;i++){
            if(!set.contains(i)){
                return false;
            }
        }
        return true;
    }
}
