package com.leetcode;

public class leetcode50 {
    public static void main(String[] args) {
        System.out.println(new leetcode50().myPow(2.00000 ,-2147483648));
    }
    public double myPow(double x, int n) {
        long N=n;
        if(N<0){
            return 1/calPow(x,-1*N);
        }
        return calPow(x,N);
    }
    private double calPow(double x, long n){
        double stage=x,res=1;
        while(n>0){
            if(n%2==1){
                res*=stage;
                n=(n-1)/2;
            }else{
                n=n/2;
            }
            stage*=stage;
        }
        return res;
    }
}
