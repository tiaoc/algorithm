package com.leetcode;

import java.util.HashMap;

public class leetcode134 {
    public static void main(String[] args) {
        int[] gas  = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int fuel=0,start=0,place=0,rest=0;
        while(place<gas.length){
            fuel+=gas[place];
            if(fuel<cost[place]){
                start=place+1;
                rest+=fuel;
                rest-=cost[place];
                fuel=0;
            }else{
                fuel-=cost[place];
            }
            place=place+1;
        }
        rest+=fuel;
        if(rest<0){
            return -1;
        }else {
            return start;
        }
    }
}
