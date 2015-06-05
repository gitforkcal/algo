package com.test.algo.misc;

/**
 * @author Rahul Bhattacharjee
 */
public class BitOperations {

    public static void main(String [] argv) {
        //int data = 7;
        //System.out.println("1's " + count1(data));
        //System.out.println("0's " + count0(5));

        int val = 63;
        System.out.println("Val " + Integer.toBinaryString(val));
        int newVal = transform(val,3,2);
        System.out.println("New Vale " + Integer.toBinaryString(newVal));
    }

    private static int transform(int data, int start, int end) {
        int mask = ~1;
        int left = (mask << start);
        System.out.println("Left       " + Integer.toBinaryString(left));
        int right = (mask >>> (32-end));
        System.out.println("Right      " + Integer.toBinaryString(right));
        int finalMask = left|right;
        System.out.println("Final mask " + Integer.toBinaryString(finalMask));
        return data & finalMask;
    }

    private static int count1(int data) {
        int count = 0;
        while(data != 0) {
            if((data & 1) == 1){
                count++;
            }
            data = data >> 1;
        }
        return count;
    }

    private static int count0(int data) {
        int count = 0;
        while(data != 0) {
            if((data & 1) == 0){
                count++;
            }
            data = data >> 1;
        }
        return count;
    }
}
