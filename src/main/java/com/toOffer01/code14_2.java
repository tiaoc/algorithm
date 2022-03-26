package com.toOffer01;

public class code14_2 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
    }
    public static int cuttingRope(int n) {
        if(n<2)return 0;
        if(n==2)return 1;
        if(n==3)return 2;

        int timesOf3=n/3;
        if (n-timesOf3*3==1)
            timesOf3--;

        int timesOf2 = (n-timesOf3*3)/2;

        return (int)(Math.pow(3,timesOf3)*Math.pow(2,timesOf2));
    }
}
