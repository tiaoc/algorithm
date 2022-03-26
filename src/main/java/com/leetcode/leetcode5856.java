package com.leetcode;

import java.util.Arrays;

public class leetcode5856 {
    //分配时间段，空余时间，分配，余下的时间越少，完成时间越快
    //也不一定，如果小时间可以分在大时间后面，就不适合自己组完，组满单独的时间片
    //就是说是有后效的，前面的时间片分配要最优
    //先分配最大的？使得余下的时间最小。
    //数据量不大，可以用dfs？ 那bfs呢？
    //14
    //空缺6 ， 8 有 5 5 5 5 5 3 3
    public static void main(String[] args) {
        int[] tasks=new int[]{2,3,3,4,4,4,5,6,7,10};//10 2    7 5    6 3 3     4 4 4
        int s=12;
        System.out.println(new leetcode5856().minSessions(tasks,s));
    }
    int res=0;
    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        int n = tasks.length;
        boolean[] flag=new boolean[n];
        for(int i=0;i<n;i++) {
            Resp a=dfs(tasks, sessionTime, n-1, 0, flag);
            flag=a.flag;
            res++;
            boolean out=true;
            for(int j=0;j<n;j++){
                if(!flag[j]){
                    out=false;
                    break;
                }
            }
            if(out){
                break;
            }
        }
        return res;
    }

    private Resp dfs(int[] tasks, int sessionTime, int idx, int curVal,boolean[] flag) {
        if(idx==-1){
            return new Resp(Arrays.copyOf(flag,flag.length),curVal);
        }
        if(flag[idx]||curVal + tasks[idx]>sessionTime){
            return dfs(tasks,sessionTime,idx-1,curVal,Arrays.copyOf(flag,flag.length));
        }
        Resp a=dfs(tasks,sessionTime,idx-1,curVal,Arrays.copyOf(flag,flag.length));
        curVal+=tasks[idx];
        flag[idx]=true;
        Resp b=dfs(tasks,sessionTime,idx-1,curVal,Arrays.copyOf(flag,flag.length));
        if(a.curVal>b.curVal){
            return a;
        }else{
            return b;
        }
    }
    static class Resp{
        boolean[] flag;
        int curVal;

        public Resp(boolean[] flag, int curVal) {
            this.flag=flag;
            this.curVal=curVal;
        }
    }
}
