package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode5836 {
    //最近的路不会走回头路，在所有road中找到最小的值，然后呢？
    //将它添加到已有的树中？记录到达某个地点的最小值和其次数？
    // pq 表示road。每次去出，更新nn的二维表？
    public int countPaths(int n, int[][] roads) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        for(int[] road:roads){
            pq.offer(road);
        }
        while(!pq.isEmpty()){
            int[] cur=pq.poll();

        }
        return 0;
    }
}
