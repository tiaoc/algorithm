package com.leetcode;

import java.util.Arrays;

public class leetcode5831 {
    //尽量消耗多的
    //由小的确定大的限制
    //一个数组，自己目前能消耗多少，自己最多能消耗多少
    //目前能消耗的+1是能帮下一个搞的，这是一个限制，自己最多消耗是累和，问题在于新来的是不是都能消耗前面的，应该可以-两个交替就行
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(numberOfWeeks(nums));
    }
    public static long numberOfWeeks(int[] milestones) {
        Arrays.sort(milestones);
        //ability=curcumsum+1
        long curCumsum=1,redCumsum=milestones[0]-1;
        for(int i=1;i<milestones.length;i++){
            if(milestones[i]>curCumsum+redCumsum+1){
                long temp=milestones[i]-curCumsum-redCumsum-1;
                curCumsum+=curCumsum+redCumsum+1;
                redCumsum=temp;
            }else if(milestones[i]>curCumsum+1){
                long temp=curCumsum+redCumsum-milestones[i]-1;
                curCumsum+=milestones[i]+1;
                redCumsum=temp;
            }else if(milestones[i]<=curCumsum+1){
                long temp=redCumsum+curCumsum-milestones[i]-1;
                curCumsum+=milestones[i]+1;
                redCumsum=temp;
            }
        }
        return curCumsum;
    }
    //正解
    public long numberOfWeeks1(int[] milestones) {
        Arrays.sort(milestones);
        //ability=curcumsum+1
        long curCumsum=0,redCumsum=0;
        for(int i=0;i<milestones.length-1;i++){
            curCumsum+=milestones[i];
        }
        if(curCumsum+1>milestones[milestones.length-1]){
            return curCumsum+milestones[milestones.length-1];
        }else{
            return curCumsum+curCumsum+1;
        }
    }
}
