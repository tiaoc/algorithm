package com.toOffer01;

public class code10 {
    public static void main(String[] args) {
        System.out.println(fib(45));
    }

    public static int fib(int n) {
        if (n == 0) return 0;
        int[] f = {0, 1};
        return fibb(f, n)[1];
    }

    public static int[] fibb(int[] f, int index) {
        if (index <= 1) return f;
        int temp = (f[0] + f[1]) % 1000000007;
        f[0] = f[1];
        f[1] = temp;
        return fibb(f, --index);
    }
//    public static int Fibonacci(int n) {
//        int[] f={0,1};
//        return fib(f,n)[0];
//    }
//    public static int[] fib(int[] f,int index){
//        if(index>0){
//            int fn=f[0]+f[1];
//            int[] ff={f[1], fn};
//            index--;
//            return fib(ff,index);
//        }else{
//            return f;
//        }
//    }
}
