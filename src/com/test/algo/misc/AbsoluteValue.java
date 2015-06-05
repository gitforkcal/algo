package com.test.algo.misc;

/**
 *
 */
public class AbsoluteValue {

    public static void main(String [] argv) {
        int a = 7;
        int mask = a >> 31;
        int val = (mask ^ a) - mask;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(val);
    }
}
