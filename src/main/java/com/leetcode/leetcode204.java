package com.leetcode;

public class leetcode204 {
    public int countPrimes(int n) {
        int count=0;
        boolean[] table=new boolean[n];
        for(int i=2;i<Math.sqrt(n);i++){
            if(!table[i]){//是质数
                for(int j=i*i;j<n;j+=i){//质数乘自身，乘2，乘3.。乘到最大小于n
                    table[j]=true;
                }
            }
        }
        for(int i=2;i<n;i++){
            if(!table[i]){
                ++count;
            }
        }
        return count;
    }
}
