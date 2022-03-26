package com.somehistory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class qianxin0102 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums=new int[9];
        String str=in.nextLine();
        System.out.println(str.length());
        for(int i=0;i<9;i++){
            nums[i]=str.charAt(2*i)-'0';
        }

        System.out.println(Arrays.deepToString(permute(nums)));
    }
    public static int[][] permute(int[] nums){
        ArrayList<int[]> list=new ArrayList<>();
        int s1=0,s2=0,s3=0;
        for(int i=0;i<4;i++){
            s1+=nums[i];
        }
        for(int i=3;i<6;i++){
            s2+=nums[i];
        }
        for(int i=6;i<8;i++){
            s3+=nums[i];
        }
        s3+=nums[0];
        if(s1==s2&&s2==s3){

        }
        int[][] result={{3,4,8,5,2,6,7,1,9}};
        return result;
    }
}
