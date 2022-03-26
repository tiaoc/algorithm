package com.toOffer02;

import java.util.ArrayList;
import java.util.Scanner;

public class meituan2 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int a=in.nextInt();
        System.out.println(func(a));
    }
    private static String func(int a){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int temp=a;
        for(int i=2;i<a/2;i++){
            if(temp%i==0){
                arrayList.add(i);
                temp/=i;
                i--;
            }
        }
        StringBuilder str=new StringBuilder();
        str.append(arrayList.get(0));
        int count=1;
        for(int i=1;i<arrayList.size();i++){
            if(!arrayList.get(i).equals(arrayList.get(i - 1))){
                str.append("*");
                str.append(arrayList.get(i));
            }else{
                count++;
                if(i<=arrayList.size()-2&& !arrayList.get(i + 1).equals(arrayList.get(i))||i==arrayList.size()-1){
                    str.append("^");
                    str.append(count);
                    count=1;
                }
            }
        }
        return str.toString();
    }
}
