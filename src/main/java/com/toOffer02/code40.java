package com.toOffer02;

import java.util.Arrays;

public class code40 {
    public static void main(String[] args) {
        int[] arr={0,0,0,2,0,5};
        System.out.println(Arrays.toString(getLeastNumbers(arr,  4)));
    }
//    public static int[] getLeastNumbers(int[] arr, int k) {
//        if(k==0) {
//            return new int[]{};
//        }
//        int start=0,end=arr.length-1;
//        int index=partition(arr,start,end);
//        while(index!=k-1){
//            if(index<k-1){
//                start=index+1;
//            }else {
//                end=index-1;
//            }
//            index=partition(arr,start,end);
//        }
//        return Arrays.copyOfRange(arr,0,k);
//    }
//    private static int partition(int[] arr,int start,int end){
//        int pivot=arr[end];
//        while(start<end){
//            while(start<end&&arr[start]<pivot){
//                start++;
//            }
//            if(start<end){
//                arr[end--]=arr[start];
//            }
//            while(start<end&&arr[end]>pivot){
//                end--;
//            }
//            if(start<end){
//                arr[start++]=arr[end];
//            }
//        }
//        arr[start]=pivot;
//        return start;
//    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        int start=0,end=arr.length-1;
        int index=partition(arr,start,end);
        while(index!=k-1){
            if(index<k-1){
                start=index+1;
            }else {
                end=index-1;
            }
            index=partition(arr,start,end);
        }
        return Arrays.copyOfRange(arr,0,k);
    }
    public static int partition(int[] arr,int start,int end){
        int pivot=arr[end];
        while(start<end){
            while(start<end&&arr[start]<pivot){
                start++;
            }
            if(start<end){
                arr[end--]=arr[start];
            }
            while(start<end&&arr[end]>pivot){
                end--;
            }
            if(start<end){
                arr[start++]=arr[end];
            }
        }
        arr[start]=pivot;
        return start;
    }
}
