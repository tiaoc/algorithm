package com.toOffer01;

public class code05 {
    public static void main(String[] args) {
        StringBuffer a=new StringBuffer("33 3");
        System.out.println(replaceSpace(a));
    }
    public static String replaceSpace(StringBuffer str) {
        for (int i=0;i<str.length();i++){
            int temp=str.charAt(i);
            if (temp==32){
                str.setCharAt(i,'%');
                str.insert(i+1,"20");
            }
        }
        return str.toString();
    }
}
