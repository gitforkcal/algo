package com.test.algo.misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rahul
 */
public class RadixSort {

    public static final int MAX_WIDTH = 3;

    public static int [] sort(int [] data) {
        Queue<Integer>[] table = new Queue[10];
        for(int i = 0 ; i < 10 ; i++) {
            table[i] = new LinkedList();
        }
        for(int i = 0 ; i < MAX_WIDTH ; i++) {
            int radix = i;
            for(int j = 0 ; j < data.length ; j++) {
                int val = data[j];
                table[getIthDigit(val,radix)].offer(val);
            }
            emptyQueueInArray(table, data);
        }
        return data;
    }

    private static void resetQueue(Queue<Integer>[] table) {
        for(Queue<Integer> queue : table) {
            queue.clear();
        }
    }

    private static void emptyQueueInArray(Queue[] table, int[] data) {
        int i = 0;
        for(int j = 0 ; j < 10 ; j++) {
            Queue<Integer> queue = table[j];
            while(!queue.isEmpty()) {
                data[i++] = queue.poll();
            }
        }
        resetQueue(table);
    }

    public static int getIthDigit(int num , int radix) {
        while(radix > 0) {
            num /= 10;
            radix--;
        }
        return num % 10;
    }

    public static void main(String [] argv) {
        int [] data = {1,5,3,20,58,600};
        System.out.println(Arrays.toString(data));
        data = sort(data);
        System.out.print(Arrays.toString(data));
    }

    public static void main1(String [] argv) {
        System.out.println(getIthDigit(123,5));
    }
}
