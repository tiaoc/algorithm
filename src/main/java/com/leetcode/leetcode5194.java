package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode5194 {
    public static void main(String[] args) {
        System.out.println(minMoves(10, 4));
    }

    public static int minMoves(int target, int maxDoubles) {
        int count=0,db=maxDoubles;
        for (int i=0;i<maxDoubles;i++) {
            if (target == 1){
                db=i;
                break;
            }
            if(target % 2 ==1){
                count++;
            }
            target = target/2;
        }
        return count + db + target-1;
    }
}
