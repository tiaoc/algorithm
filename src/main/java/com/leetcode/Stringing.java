package com.leetcode;

import java.util.Scanner;

public class Stringing {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            String str=in.nextLine();
            System.out.println(func(n,str));
        }
    }
    private static int func(int n,String str){
        boolean flag=false;
        StringBuilder builder=new StringBuilder();
        builder.append(str.charAt(0));
        return 0;
    }
}
