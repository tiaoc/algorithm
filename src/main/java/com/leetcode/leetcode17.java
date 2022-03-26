package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode17 {
    List<String> res=new ArrayList<>();
    StringBuilder sb=new StringBuilder();

    public static void main(String[] args) {

    }
    public List<String> letterCombinations(String digits) {
        String[] chars=new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        dfs(0,digits,chars);
        return res;
    }
    private void dfs(int cur,String digits,String[] chars){
        if(cur==digits.length()){
            res.add(sb.toString());
            return;
        }
        for(int i=0;i<3;i++){
            sb.append(chars[digits.charAt(cur)-'2'].charAt(0+i));
            dfs(cur+1,digits,chars);
            sb.deleteCharAt(sb.length()-1);
        }
        if(chars[digits.charAt(cur)-'2'].length()==4){
            sb.append(chars[digits.charAt(cur)-'2'].charAt(3));
            dfs(cur+1,digits,chars);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static class leetcode474 {
        public static void main(String[] args) {

        }
    }
}
