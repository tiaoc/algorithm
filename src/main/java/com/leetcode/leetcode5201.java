package com.leetcode;

public class leetcode5201 {
    public int wateringPlants(int[] plants, int capacity) {
        int cur = capacity,res=0;
        for (int i = 0; i < plants.length; i++) {
            if (cur >= plants[i]) {
                cur -= plants[i];
                res++;
            } else {
                res+=i*2;
                cur=capacity-plants[i];
                res++;
            }
        }
        return res;
    }
}
