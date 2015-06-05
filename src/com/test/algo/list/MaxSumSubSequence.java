package com.test.algo.list;

/**
 * @author Rahul Bhattacharjee
 */
public class MaxSumSubSequence {

    public static void main(String [] args) {
        //int [] data = {-2,1,-3,4,-1,2,1,-5,4};
        //int [] data = {-2,-1,-5,-7};
         //int []  data = {-2,-5,0,-1,-7};
        //int max = maxSubArraySum(data);

        int[]  data = {6, -3, -10, 0, 2};
        int max = maxProductEndingHere(data);
        System.out.println("Max sum is " + max);
    }

    private static int maxSubArraySum(int[] data) {
        int maxTillHere = 0;
        int sum = 0;
        for(int i = 0 ; i < data.length; i++) {
            sum += data[i];
            if(sum < 0) {
                sum = 0;
            }
            if(sum>maxTillHere){
                maxTillHere = sum;
            }
        }
        return maxTillHere;
    }

    private static int maxProductEndingHere(int [] data) {
        int maxTillHere = 1;
        int minTillHere = 1;
        int maxProduct = 1;

        for(int i = 0 ; i < data.length ;i++) {
            int current = data[i];

            if(current>0) {
                maxTillHere = maxTillHere*current;
                minTillHere = Math.min(minTillHere*current,1);
            } else if (current ==0) {
                maxTillHere = 1;
                minTillHere = 1;
            } else {
                int temp = maxTillHere;
                maxTillHere = Math.max(minTillHere*current,1);
                minTillHere = temp*current;
            }
            if(maxProduct < maxTillHere) {
                maxProduct = maxTillHere;
            }
        }
        return maxProduct;
    }
}
