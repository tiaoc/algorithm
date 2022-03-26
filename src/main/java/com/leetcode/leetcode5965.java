package com.leetcode;

import java.util.HashMap;

public class leetcode5965 {
    public long[] getDistances(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long[][] count = new long[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                count[i][0] = count[map.get(arr[i])][0] + (count[map.get(arr[i])][1]+1) * (i-map.get(arr[i]));
                count[i][1] = count[map.get(arr[i])][1] + 1;
            }
            map.put(arr[i], i);
        }

        map = new HashMap<>();
        long[][] count2=new long[arr.length][2];
        for (int i = arr.length-1; i >=0; i--) {
            if (map.containsKey(arr[i])) {
                count2[i][0] = count2[map.get(arr[i])][0] + (count2[map.get(arr[i])][1]+1) * (map.get(arr[i])-i);
                count2[i][1] = count2[map.get(arr[i])][1] + 1;
            }
            map.put(arr[i], i);
        }
        long[] res=new long[arr.length];
        for(int i=0;i<arr.length;i++){
            res[i] = count[i][0]+count2[i][0];
        }
        return res;
    }
}
