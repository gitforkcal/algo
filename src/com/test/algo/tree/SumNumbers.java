package com.test.algo.tree;

public class SumNumbers {

    public static void main(String [] argv) {
        int [] data = {1,2,3,4,5,6,8,9,10};
        System.out.print(findSum(data,178));
    }

    private static boolean findSum(int[] data, int sum) {
        int start = 0;
        int end = data.length-1;

        while(start < end) {
            int currentSum = data[start] + data[end];
            if(currentSum == sum) {
                return true;
            } else {
                if(currentSum > sum) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return false;
    }
}
