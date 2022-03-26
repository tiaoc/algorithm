package com.leetcode;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class leetcode5980 {
    public String[] divideString(String s, int k, char fill) {
        int len = (s.length() + k - 1) / k;
        String[] res = new String[len];
        for (int i = 0; i < len - 1; i++) {
            res[i] = s.substring(i*k,(i+1)*k);
        }
        String last= s.substring((len-1)*k);
        int add = k - last.length();
        if(add>0) {
            String tmp = IntStream.range(1, add).mapToObj(index ->"" +fill).collect(Collectors.joining());
            last = last + tmp;
        }
        res[len-1] = last;
        return res;
    }
}
