package com.somehistory;

public class c27 {
    public static void main(String[] args) {
        String str ="S12A";
        System.out.println(func(str));//转换为SACADAA
    }
    private static String func(String str){
        //将字符串原来是大写字符A的字符替换为AA，原来是数字的字符变为A+一个字符，
        //如0变为AB,1变为AC，9变为AJ。
        //变为原字符串时AA变为A，AB-AJ对应变回0-9
        StringBuilder res=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)<='Z'&&str.charAt(i)>'A'){
                res.append(str.charAt(i));
            }else if(str.charAt(i)=='A'){
                res.append("AA");
            }else{
                res.append('A');
                res.append((char)('A'+str.charAt(i)-'0'+1));
            }
        }
        return res.toString();
    }
}
