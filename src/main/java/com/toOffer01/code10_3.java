package com.toOffer01;

public class code10_3 {
    //变态跳台阶
    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
    public static void main(String[] args) {
        System.out.println(JumpFloorII(3));
    }
    public static int JumpFloorII(int target) {
        if (target == 0) return 0;
        int[] ff=new int[target+1];
        ff[0]=1;
        ff[1]=1;
        for (int i = 2; i <=target; i++) {
            ff[i]=0;
            for(int j=0;j<i;j++){
                ff[i]+=ff[j];
            }
        }
        return ff[target];
    }
}
