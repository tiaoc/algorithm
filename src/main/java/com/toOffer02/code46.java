package com.toOffer02;

public class code46 {
    public static void main(String[] args) {
        System.out.println(translateNum(58113));
    }
    public static int translateNum(int num) {
        if(num>=0&&num<10)return 1;
        String numStr=String.valueOf(num);
        int a=1,b=1,c=0;
        for(int i=1;i<numStr.length();i++){
            if(numStr.charAt(i-1)=='0'||numStr.substring(i-1,i+1).compareTo("25")>0){
                c=b;
            }else {
                c=a+b;
            }
            a=b;
            b=c;
        }
        return c;
    }
}
