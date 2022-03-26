package com.leetcode;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class leetcode815 {
    public static void main(String[] args) {
        int[][] routes = new int[][]{{1,7},{3,5}};
        System.out.println(new leetcode815().numBusesToDestination(routes,5,5));
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        //某个站台存在于哪几条线路
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //到达某个线路的公交车次数
        HashMap<Integer, Integer> m = new HashMap<>();
        //bfs遍历队列,存经过的路线
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int n = routes.length;
        for (int i = 0; i < n; i++) {
            for (int station : routes[i]) {
                if (station == source) {
                    //路过source的所有线路i都添加到dq中
                    dq.addLast(i);
                    m.put(i, 1);
                }
                Set<Integer> set = map.getOrDefault(station, new HashSet<>());
                set.add(i);
                map.put(station, set);
            }
        }
        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            int time = m.get(cur);
            for (int station : routes[cur]) {
                if(station == target) {
                    return time;
                }
                for(int j : map.get(station)) {
                    if (!m.containsKey(j)) {
                        m.put(j, time + 1);
                        dq.addLast(j);
                    }
                }
            }
        }
        return -1;
    }
}
