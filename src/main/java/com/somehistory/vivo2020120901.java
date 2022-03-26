package com.somehistory;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class vivo2020120901 {
    public static void main(String[] args) {
        System.out.println(combin1(5,3));
        //treemap 小在前
        TreeMap<Integer,Integer> map=new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        map.put(-1,2);
        map.put(3,2);
        map.put(4,2);
        int a=map.firstKey();
        System.out.println(a);
        int c=map.ceilingKey(-5);
        System.out.println("c="+c);
        //queue 小在前
        Queue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        queue.offer(1);
        queue.offer(3);
        queue.offer(5);
        int b=queue.poll();
        System.out.println(b);
    }
    static int combin1(int m, int n)//从m个数中取n个数的组合
    {
        if (m == n || n == 0) {
            return 1;
        } else {
            return combin1(m - 1, n) + combin1(m - 1, n - 1);
        }

    }
}
