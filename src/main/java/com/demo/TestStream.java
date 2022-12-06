package com.demo;

import org.apache.logging.log4j.util.PropertySource;

import java.util.Arrays;
import java.util.Comparator;

public class TestStream {
    public static void main(String[] args) {
        int[] arr = new int[100000000];
        Arrays.fill(arr, 100233);
        long s = System.currentTimeMillis();
        Arrays.stream(arr).max().getAsInt();
        System.out.println(System.currentTimeMillis() - s);
        s = System.currentTimeMillis();
        int max = 0;
        for (int child : arr) {
            max = Math.max(child, max);
        }
        System.out.println(System.currentTimeMillis() - s);
    }
}
