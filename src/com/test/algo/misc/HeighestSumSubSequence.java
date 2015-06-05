package com.test.algo.misc;

/**
 * @author Rahul
 */
public class HeighestSumSubSequence {
    public static void main(String [] argv) {
        int [] data = {-2, -3, 4, -1, -2, 1, 5, -3};
        int length = getLengthOfSubSequence(data);
        System.out.println("Length " + length);
    }

    private static int getLengthOfSubSequence(int[] data) {
        int max = 0;
        int sum = 0;
        for(int i = 0 ; i < data.length ; i++) {
            sum = sum + data[i];
            if(sum <= 0) {
                sum = 0;
                max = 0;
            } else {
                max++;
            }
        }
        return max;
    }
}
