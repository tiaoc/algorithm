package com.leetcode;

public class leetcode5830 {
    //1、自己、还有一个。不是质数，是质数的倍数
    //4 9
    //只能是平方,质数的平方，质数的立方
    public static void main(String[] args) {
        System.out.println(isThree(12));
    }
    public static boolean isThree(int n) {
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(n/i==i){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }
}
