package com.test.algo.misc;

/**
 * @author Rahul
 */
public class BitVector {

    private static int [] data = new int[40];

    public static void main(String [] argv) {
        set(1000);
        System.out.println(" Present " + get(1000));
        System.out.println(" Present " + get(999));
        System.out.println(" Present " + get(1001));
    }

    private static boolean get(int i) {
        int index = i/32;
        int val = data[index];
        int newVal = 1 << i;
        if((val & newVal) > 1) {
            return true;
        }
        return false;
    }

    private static void set(int i) {
        int index = i/32;
        int bit = i%32;
        int value = 1 << bit;
        value |= data[index];
        data[index] = value;
    }
}
