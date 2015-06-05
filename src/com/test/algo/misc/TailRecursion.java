package com.test.algo.misc;

/**
 * Tail recursion to add number from 1....n
 * @author Rahul
 */
public class TailRecursion {

    public static void main(String [ ]a) {
        int sum = sum(4);
        System.out.println(sum);
    }

    private static int sum(int index) {
        return sum(index,0);
    }

    private static int sum(int index, int sum) {
        if(index == 0)
            return sum;

        return sum(index-1,sum+index);
    }
}
