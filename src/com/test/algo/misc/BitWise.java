package com.test.algo.misc;

/**
 * @author Rahul
 */
public class BitWise {

    public static int count1(int n) {
        if(n == 0){
            return 0;
        }
        return (n&1) + count1(n >> 1);
    }

    public static int count0(int n) {
        if(n == 0){
            return 0;
        }
        int val = (n&1);
        if(val == 0) {
            return 1 + count0(n >> 1);
        } else {
            return count0(n >> 1);
        }
    }

    public static int findHeighestBitIndex(int n) {
        if(n == 0){
            return 0;
        }
        return 1 + findHeighestBitIndex(n>>1);
    }

    public static void main(String [] argv) {
        int n = 11;
        System.out.println("1's " + count1(n));
        System.out.println("0's " + count0(n));
        System.out.println("Heighest 1 " + findHeighestBitIndex(n));
    }
}
