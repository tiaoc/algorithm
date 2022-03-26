package com.somehistory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class c28 {
    //    1 targetLength=str.length+whiteCount*2;
//    2 str[targetLength--]='0';
//    3 str[targetLength--]='%';
//    4 targetLength--;
//    5 usedLength--;
//    6 replaceBlank(string,str.length)
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(shuffle(array, k)));
    }

    private static int[] shuffle(int[] array, int k) {
        if (k == 0) return array;
        int[] a = Arrays.copyOfRange(array, 0, array.length/2);
        int[] b = Arrays.copyOfRange(array, array.length/2, array.length);
        ArrayList<Integer> list=new ArrayList<>();
        if(k%2==0){
            int m=0;
            while(m<a.length){
                if(m%2==0) {
                    list.add(a[m]);
                    list.add(b[b.length-1-m]);
                }else {
                    list.add(b[m]);
                    list.add(a[a.length-1-m]);
                }
                m++;
            }
        }else{
            int m=0;
            while(m<a.length){
                if(m%2==0) {
                    list.add(b[m]);
                    list.add(a[a.length-1-m]);
                }else {
                    list.add(a[m]);
                    list.add(b[b.length-1-m]);
                }
                m++;
            }
        }
        int[] res=new int[array.length];
        for(int i=0;i<array.length;i++){
            res[i]=list.get(i);
        }
        return shuffle(res,--k);
    }
}
