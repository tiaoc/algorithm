package com.toOffer02;

public class code44 {
    public static void main(String[] args) {
        System.out.println(findNthDigit(3));
    }
    public static int findNthDigit(int n) {
        long maxnum=0;
        long pow = 1,bit=0;
        while(maxnum<n) {
            bit+=1;//位数增加
            pow*=10;//最高位的权-pow增加
            maxnum+=bit*(pow-(pow/10));//最大数
        }
        long start=maxnum-bit*pow*9/10;//之前位数对应的开始
        long num=pow/10+(n-start-1)/bit;//在当前位数里找到n对应的那个数num
        return String.valueOf(num).charAt((int) ((n-start-1)%bit))-'0';
        //(n-start-1)%bit是n在num中的位数
    }
}
