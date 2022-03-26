package com.leetcode.editor.cn;

import java.util.ArrayList;

public class Dptest {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        int endX=4,endY=5;
        boolean[][] visited =new boolean[endX][endY];
        dfs(0,0,endX,endY,new StringBuilder(),visited,list);
        System.out.println(list);
        System.out.println(list.size());
    }
    private static void dfs(int x,int y,int endX,int endY,StringBuilder cur,boolean[][] visited,ArrayList<String> list){
        if(x==endX||y==endY||visited[x][y]){
            return;
        }
        if(x==endX-1&&y==endY-1){
            list.add(cur.toString());
            return;
        }
        visited[x][y]=true;
        cur.append("0");
        dfs(x+1,y,endX,endY,cur,visited,list);
        cur.deleteCharAt(cur.length()-1);
        cur.append("1");
        dfs(x,y+1,endX,endY,cur,visited,list);
        cur.deleteCharAt(cur.length()-1);
        visited[x][y]=false;
    }
}
