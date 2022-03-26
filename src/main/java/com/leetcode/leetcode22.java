package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class leetcode22 {
    public static void main(String[] args) {
        leetcode22 m=new leetcode22();
        System.out.println(m.generateParenthesis(3));
    }
    List<String> res=new ArrayList<>();
    StringBuilder s=new StringBuilder();
    public List<String> generateParenthesis(int n) {
        dfs(0,0,n);
        return res;
    }
    private void dfs(int left,int right,int n){
        if(right>left){
            return;
        }
        if(left+right==n*2){
            if(left==right){
                res.add(s.toString());
                return;
            }
            return;
        }
        s.append('(');
        dfs(left+1,right,n);
        s.replace(s.length()-1,s.length(),")");
        dfs(left,right+1,n);
        s.deleteCharAt(s.length()-1);

    }


    public static class Leetcode554 {
        public int leastBricks(List<List<Integer>> wall) {
            List<int[]>list=new ArrayList<>();
            for(List<Integer> layer:wall){
                int cur=0;
                for (Integer integer : layer) {
                    list.add(new int[]{cur, cur + integer});
                    cur += integer;
                }
            }
            list.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if(a[0]==b[0]){
                        return a[1]-b[1];
                    }
                    return a[0]-b[0];
                }
            });
            ArrayList<int[]> window=new ArrayList<>();
            for(int i=0;i<wall.size();i++) {
                window.add(list.get(i));
            }
            int res=Integer.MAX_VALUE;
            for(int i=wall.size();i<list.size();i++){
                res=Math.min(window.size(),res);
                for(int j=0;j<window.size();j++) {
                    if(window.get(j)[1] <= list.get(i)[0]) {
                        window.remove(j);
                    }
                    window.add(list.get(i));
                }
            }
            return res;
        }
    }
}
