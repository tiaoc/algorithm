package com.toOffer02;

import java.util.LinkedList;

public class code59_2 {
    class MaxQueue {
        LinkedList<Integer> queue;
        LinkedList<Integer> max;
        public MaxQueue() {
            queue=new LinkedList<>();
            max=new LinkedList<>();
        }

        public int max_value() {
            if(max.isEmpty()){
                return -1;
            }
            return max.peekFirst();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!max.isEmpty() && max.peekLast() < value) {
                max.pollLast();
            }
            max.offer(value);
        }
        public int pop_front() {
            if(queue.isEmpty()){
                return -1;
            }
            if(queue.peekFirst().equals(max.peekFirst())){
                return max.pollFirst();
            }
            return queue.pollFirst();
        }
    }
}
