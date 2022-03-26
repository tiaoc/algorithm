package com.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode5805 {
    //空的座位号
    //按照离开时间排序，
    //空的在前面
    //空的，座位号小的在前面。实的不考虑
    //先按进入时间把客人排序
    //
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        for(int i=0;i<times.length;i++){
            queue.offer(new int[]{i,times[i][0],times[i][1]});
        }
        //表示座位。
        //空着的
        PriorityQueue<Integer> seat_empty =new PriorityQueue<>();
        //坐着的
        for(int i=0;i<times.length;i++){
            seat_empty.offer(i);
        }
        PriorityQueue<int[]> seat_fill =new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            while(!seat_fill.isEmpty()&&seat_fill.peek()[0]<=cur[1]){
                int empty=seat_fill.poll()[1];
                seat_empty.offer(empty);
            }
            int nextSeat=seat_empty.poll();
            seat_fill.offer(new int[]{cur[2],nextSeat});
            if(cur[0]==targetFriend){
                return nextSeat;
            }
        }
        return 0;
    }
}
