package com.leetcode;

public class leetcode5768 {
    public static void main(String[] args) {
        //int a=100000*100000;
        long a=100000L*100000;
        System.out.println(a);
    }
    //前缀和
    public int chalkReplacer(int[] chalk, int k) {
        long sum=0;
        for(int val:chalk){
            sum+=val;
        }
        long layer=k%sum;
        for(int i=0;i<chalk.length;i++){
            if(layer<chalk[i]){
                return i;
            }
            layer-=chalk[i];
        }
        return chalk.length-1;
    }
}
