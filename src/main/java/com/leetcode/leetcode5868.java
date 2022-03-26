package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode5868 {
    //c x x
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> map = new HashMap<>();
        for(int[] rec : rectangles){
            map.put((double)rec[0]/(double)rec[1], map.getOrDefault((double)rec[0]/rec[1],0)+1);
        }
        long count=0;
        for (Map.Entry<Double, Integer> en: map.entrySet()){
            for (int i=en.getValue()-1;i>0;i--){
                count+=i;
            }
        }
        return count;
    }
}
