package com.leetcode.editor.cn;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 *
 * If you define many classes, but you must have a class named Main and a public property.
 * The Main class should be the only public class.
 * The Main class must contain a static method (function) named "main"
 * Do not add any package, like "package main"
 *
 * The TestCase is shown below
 * Input : 1 2
 * Output : 3
 */

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int	a = in.nextInt();
        Queue<Integer> queue=new LinkedList<>();
        for(int i=1;i<=a;i++){
            queue.add(i);
        }
        ArrayList<Integer> out=new ArrayList<>();
        Queue<Integer> queue2=new LinkedList<>();
        boolean flag=false;
        while(queue.size()>2){
            if(flag){
                out.add(queue.poll());
                flag=false;
            }
            while(queue.size()>2){
                queue2.add(queue.poll());
                out.add(queue.poll());
            }
            if(queue.size()==1) {
                queue2.add(queue.poll());
                flag = true;
            }
            if(queue.size()==0){
                queue=queue2;
                queue2=new LinkedList<>();
            }
        }
        for(int i=0;i<out.size();i++){
            System.out.print(out.get(i)+" ");
        }
        System.out.println(" ");
        while(!queue.isEmpty()){
            System.out.print(queue.poll()+" ");
        }
    }
}