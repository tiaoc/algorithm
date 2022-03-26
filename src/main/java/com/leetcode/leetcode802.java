package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class leetcode802 {
    public static void main(String[] args) {
        int[][] graph={{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        HashSet<Integer> set=new HashSet<>();
        int size=-1;
        while(set.size()!=size){
            size=set.size();
            for(int i=0;i<graph.length;i++){
                if(graph[i].length==0){
                    set.add(i);
                    continue;
                }
                boolean flag=false;
                for(int j=0;j<graph[i].length;j++){
                    if(!set.contains(graph[i][j])){
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    set.add(i);
                }
            }
        }
        List<Integer> res = new ArrayList<>(set);
        return res;
    }
}
