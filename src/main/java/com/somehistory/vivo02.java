package com.somehistory;
import java.util.Scanner;

public class vivo02 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int K=in.nextInt();
        int N=in.nextInt();
        System.out.println(func(N,K));
    }
    private static int func(int n,int k){
        int left=0,right=n,count=0;
        while(left<right){
            int mid=(right-left)/2;
            right=mid;
            count++;
        }
        if(count<k*2){
            return count;
        }else {
            return count+(count-2*k)/2;
        }
    }
}
