package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode5900 {

    public static void main(String[] args) {
        String s="***|**|*****|**||**|*";
        int[][] nums={{1,17},{4,5},{14,17},{5,11},{15,16}};
        System.out.println(Arrays.toString(platesBetweenCandles(s, nums)));
    }
    //记录每个盘子最近的左右蜡烛
    //只需要找到每个query的最边上的两个蜡烛，和这两个蜡烛中间包着的盘子个数
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int n=s.length();
        int [] nums=new int[n+1];
        int[] leftCandle=new int[n+1];
        int[] rightCandle=new int[n+1];
        for(int i=1;i<=n;i++){//i=1 0不表示数
            nums[i]=nums[i-1];
            if(s.charAt(i-1)=='*'){
                nums[i]++;
                leftCandle[i]=leftCandle[i-1];
            }else {
                leftCandle[i]=i;
            }
        }
        for(int i=n;i>0;i--){// i=n-1,n肯定不算
            if(s.charAt(i-1)=='|') {
                rightCandle[i] = i;
            }else if (i!=n){
                rightCandle[i] = rightCandle[i+1];
            }
        }
        int[] res=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int left=rightCandle[queries[i][0]+1]-1,right= leftCandle[queries[i][1]+1];
            res[i]=nums[right]-nums[left];
            res[i]=Math.max(res[i],0);
        }
        return res;
    }
}
