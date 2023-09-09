package com.server2023;

import java.util.Arrays;
import java.util.List;

public class leetcode6918 {
    public static void main(String[] args) {
        System.out.println(new leetcode6918().minimumString("cab", "a", "b"));
    }

    //　ab ac bc
    // 谁在中间
    // a包含bc
    public String minimumString(String a, String b, String c) {
        if (b.contains(a)||c.contains(a)){
            a="";
        }
        if (a.contains(b)||c.contains(b)){
            b="";
        }
        if (a.contains(c)||b.contains(c)){
            c="";
        }
        String s1 = minimumTriple(a, b, c);
        String s2 = minimumTriple(b, a, c);
        String s3 = minimumTriple(a, c, b);
        List<String> r = Arrays.asList(s1, s2, s3);
        r.sort((a1, b1) -> {
            if (a1.length() != b1.length()) {
                return a1.length() - b1.length();
            }
            return a1.compareTo(b1);
        });
        return r.get(0);
    }

    private String minimumTriple(String a, String b, String c) {
        String prefix1 = minimumDouble(a, b);
        String total1 = minimumDouble(prefix1, c);

        String prefix2 = minimumDouble(c, b);
        String total2 = minimumDouble(prefix2, a);
        if (total1.length() < total2.length()) {
            return total1;
        } else if (total1.length() > total2.length()) {
            return total2;
        } else if (total1.compareTo(total2) <= 0) {
            return total1;
        } else {
            return total2;
        }
    }

    private String minimumDouble(String a, String b) {
        int startA = 0;
        if (b.length() < a.length()) {
            startA = a.length() - b.length();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = startA; i <= a.length(); i++) {
            if (b.substring(0, a.length() - i).equals(a.substring(i))) {
                sb.append(a, 0, i).append(b);
                break;
            }
        }
        if (sb.length() == 0) {
            sb.append(a).append(b);
        }
        return sb.toString();
    }
}
