package com.leetcode;

public class leetcode5187 {
    //0, 01  增加的是累和
    //每次增加一个周长
    //增加的周长和上一个周长的区别在于两个角
    //也不光是两个角，就是两个角
    //四个角，角上 2 4 8 16 32 .。。。。
    public long minimumPerimeter(long neededApples) {
        long init=12,sum=12;
        long i=2;
        while(sum<neededApples){
            i+=2;
            init+=4*i+4*(i-1)+4*(i-1);
            sum+=init;
        }
        return i*4;
    }
}
