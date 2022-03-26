package com.toOffer02;

public class code49 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
    /*不能这么写，会出现2*3,3*2的重复(队列中出现两个6)，应该是array[i]的值等于array[a]*2，或者array[b]*3时,两个索引都要加。
    public static int nthUglyNumber(int n) {
        int a=0,b=0,c=0;
        int[] array=new int[n];
        array[0]=1;
        for(int i=1;i<n;i++){
            if(array[a]*2<array[b]*3&&array[a]*2<array[c]*5){
                array[i]=array[a++]*2;
            }else if(array[b]*3<array[c]*5){
                array[i]=array[b++]*3;
            }else {
                array[i]=array[c++]*5;
            }
        }
        System.out.println(Arrays.toString(array));
        return array[n-1];
    }
    */
    public static int nthUglyNumber(int n) {
        int a=0,b=0,c=0;
        int[] array=new int[n];
        array[0]=1;
        for(int i=1;i<n;i++){
            array[i]=Math.min(Math.min(array[a]*2,array[b]*3),array[c]*5);
            if(array[i]==array[a]*2) a++;
            if(array[i]==array[b]*3) b++;
            if(array[i]==array[c]*5) c++;
        }
        return array[n-1];
    }
}
