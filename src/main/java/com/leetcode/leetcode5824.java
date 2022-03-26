package com.leetcode;

public class leetcode5824 {
    //突变num的任一子字符串
    //子字符串突变，使得整数最大
    //前面的位数改变更重要，前面变一位，比后面变多少都有用
    //前面位数的改变，需要衡量改变的大，只要在前，就不用管位数，但是第一位变了以后，第二位也可能需要变
    //转换为一个状态中止的等待
    //考虑一个数字和它的映射，如果映射小于原来，那么必不会继续转换
    //用字符串表示整数
    //最大整数
    //遇到能增加就开始判断
    public String maximumNumber(String num, int[] change) {
        int i=0;
        char[] sc=num.toCharArray();
        boolean flag=false;
        while(i<sc.length){
            if(!flag){
                if(sc[i]-'0'<change[sc[i]-'0']) {
                    sc[i]= (char) (change[sc[i]-'0']+'0');
                    flag=true;
                }
            }else if(sc[i]-'0'>change[sc[i]-'0']){
                return String.valueOf(sc);
            }else {
                sc[i]= (char) (change[sc[i]-'0']+'0');
            }
            i++;
        }
        return String.valueOf(sc);
    }
}
