package com.test.algo.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.lang.Integer;

/**
 * Median using priority queues.
 *
 * @author Rahul
 */
public class MedianUsingHeap {

    private static int findMedian(int[] data) {
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(10, new DescendingComparator());
        PriorityQueue<Integer> min = new PriorityQueue<Integer>(10, new AscendingComparator());

        for(int i = 0 ; i < data.length ; i++) {
            int val = data[i];
            Integer head = max.peek();
            if(head == null || head > val) {
                max.offer(val);
            } else {
                min.offer(val);
            }
            balance(max,min);
        }
        if(max.size() == min.size()) {
            return (max.peek()+min.peek())/2;
        }else if(max.size() > min.size()) {
            return max.peek();
        } else {
            return min.peek();
        }
    }

    private static void balance(PriorityQueue<Integer> max, PriorityQueue<Integer> min) {
        if(max.size() == min.size()) {
            return;
        }
        if(max.size() > min.size()) {
            min.offer(max.poll());
        } else {
            max.offer(min.poll());
        }
    }

    public static void main(String [] argv) {
        int [] data = {1,2,3,4};
        System.out.println("Median => " + findMedian(data));
    }

    public static class AscendingComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int i1 = o1.intValue();
            int i2 = o2.intValue();

            if(i1 == i2){
                return 0;
            } else {
                return (i1-i2);
            }
        }
    }

    public static class DescendingComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int i1 = o1.intValue();
            int i2 = o2.intValue();
            if(i1 == i2) {
                return 0;
            } else {
                return (i2-i1);
            }
        }
    }
}
