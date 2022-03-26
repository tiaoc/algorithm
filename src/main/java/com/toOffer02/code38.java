package com.toOffer02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class code38 {
    public String[] permutation(String s) {
        StringBuilder stringBuilder=new StringBuilder();
        ArrayList<String> arrayList=new ArrayList<>();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }
        help(map,stringBuilder,arrayList,s.length());
        String[] ss=new String[arrayList.size()];
        for(int i=0;i<arrayList.size();i++){
            ss[i]=arrayList.get(i);
        }
        return ss;
    }
    private void help(HashMap<Character,Integer> map,StringBuilder stringBuilder,
                      ArrayList<String> arrayList,int len){
        Set<Character> keyset=map.keySet();
        for(Character key:keyset){
            if(map.get(key)>0){
                stringBuilder.append(key);
                map.put(key,map.get(key)-1);
                if(stringBuilder.length()==len){
                    arrayList.add(stringBuilder.toString());
                }
                help(map,stringBuilder,arrayList,len);
                map.put(key,map.get(key)+1);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }
    }
}
