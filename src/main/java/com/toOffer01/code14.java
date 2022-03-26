package com.toOffer01;

public class code14 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
    }
    public static int cuttingRope(int n) {
        if(n<2)return 0;
        if(n==2)return 1;
        if(n==3)return 2;
        int[] product = new int[n+1];
        int temp;
        product[1]=1;
        product[2]=2;
        product[3]=3;
        for(int i=3;i<n+1;i++){
            for(int j=1;j<=i/2;j++){
                temp=product[j]*product[i-j];
                if(temp>product[i]) product[i]=temp;
            }
        }
        return product[n];
    }
}
