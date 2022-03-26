package com.leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class leetcode5806 {
    //用和表示混合颜色
    //start,end，color
    //合并相邻同颜色区间-达到最少数目，不能重叠
    //颜色向前匹配。相同
    //区间排序
    //按照左端点排序，进入就开始算，但有多个持续工作的窗口。找到其中影响最短的。
    //之前的被分割掉的区间，要留存影响。
    //随着结束窗的推进，有更多的区间要进来，在进入的时候判断退出时不可行的。
    //先开始后结束-working waiting。
    //
    public List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> res=new LinkedList<>();
        Arrays.sort(segments, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<int[]> work=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int next=0;
        int lastOut=-1;
        int sum_window=0;
        for(int i=0;i<segments.length;i++){
            int[] cur=segments[i];
            while(!work.isEmpty()&&cur[0]>=work.peek()[1]){
                int[] out=work.poll();
                if(lastOut==out[2]){
                    List<Long> arr=res.get(res.size()-1);
                    res.remove(res.size()-1);
                    arr.set(2, (long) out[1]);
                    res.add(arr);
                }else{
                    List<Long> list=new ArrayList<>();
                    list.add((long) out[0]);
                    list.add((long) out[1]);
                    list.add((long) sum_window);
                    res.add(list);
                }
                lastOut=out[2];
                sum_window-=lastOut;
            }
            work.offer(cur);
            sum_window+=cur[2];
        }
        while(!work.isEmpty()){
            int[] out=work.poll();
            if(lastOut==out[2]){
                List<Long> arr=res.get(res.size()-1);
                res.remove(res.size()-1);
                arr.set(2, (long) out[1]);
                res.add(arr);
            }else{
                List<Long> list=new ArrayList<>();
                list.add((long) out[0]);
                list.add((long) out[1]);
                list.add((long) sum_window);
                res.add(list);
            }
            lastOut=out[2];
            sum_window-=lastOut;
        }
        return res;
    }
}
