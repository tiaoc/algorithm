package com.somehistory;

import java.util.HashMap;
import java.util.Set;

public class kuaishou {
    public static void main(String[] args) {
        String a="abcd";
        String b="eedd";
        System.out.println(GetMinDistance(a,b));
    }
    public static int GetMinDistance (String s1, String s2) {
        // write code here
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            int com=0;
            if(s1.charAt(i)==s2.charAt(i)){
                com=1;
            }
            if(!map2.containsKey(s2.charAt(i))){
                map2.put(s2.charAt(i),1-com);
            }else {
                map2.put(s2.charAt(i),map2.get(s2.charAt(i))+1-com);
            }
        }
        Set<Character> keys=map2.keySet();
        int maxvalue=0;
        Character c2;
        for(Character key:keys){
            if(map2.get(key)>maxvalue){
                c2=key;
                maxvalue=map2.get(key);
            }
        }
        return 0;
    }
}
