package com.somehistory;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {

                // write your code here
                int n=scanner.nextInt();
                ListNode[] nums = new ListNode[n];
                for(int i=0;i<n;i++){
                    ListNode temp=new ListNode(scanner.nextInt());
                    nums[i]=temp;
                    while(scanner.hasNextInt()) {
                        temp.next= new ListNode(scanner.nextInt());
                        temp=temp.next;
                    }
                }

            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        // TODO output

    }

    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    private static ListNode mergeNodes(ListNode head ) {

        // write your code here
        return new ListNode(0);
    }


}