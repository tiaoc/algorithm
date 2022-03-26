package com.toOffer02;

public class GCD {
    public static void main(String[] args) {
        for(int i=1;i<20;i++){
            for(int j=i+1;j<20;j++){
                for(int k=j+1;k<20;k++){
                    if(GongYueShu(i,j)!=1&&GongYueShu(j,k)!=1&&GongYueShu(i,k)!=1){
                        if(GongYueShu(GongYueShu(i,j),k)==1){
                            System.out.println(i+" "+j+" "+k);
                        }
                    }
                }
            }
        }
    }
    public static int GongYueShu(int a,int b){
        int c;
        while(a%b!=0)
        {
            c=a%b;
            a=b;
            b=c;
        }
        return b;
    }
    public static void GongBeiShu(int a,int b){
        int c,d=0;
        d=a*b;
        while(a%b!=0)
        {
            c=a%b;
            a=b;
            b=c;
        }
        d=d/b;
        System.out.println(d);
    }
}
