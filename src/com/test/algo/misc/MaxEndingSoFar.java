package com.test.algo.misc;

/**
 * Created with IntelliJ IDEA.
 * User: Rahul
 * Date: 4/30/14
 * Time: 8:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class MaxEndingSoFar {

    static int maxSubArraySum(int a[], int size)
    {
        int max_so_far = 0, max_ending_here = 0;
        int i;
        for(i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if(max_ending_here < 0)
                max_ending_here = 0;

     /* Do not compare for all elements. Compare only
        when  max_ending_here > 0 */
            else if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        return max_so_far;
    }

    public static void main(String [] argv) {
        //int[]data = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[]data = {-2, 3, 4, -1, -2, -1, -5, -3};
        //System.out.println(maxSubArraySum(data,data.length));
        System.out.println(maxSum(data));
    }

    private static int maxSum(int [] data) {
        int max = data[0];
        int maxTillNow = data[0];

        for(int i =1;i < data.length;i++) {
            maxTillNow += data[i];
            maxTillNow = Math.max(maxTillNow,data[i]);
            max = Math.max(maxTillNow,max);

        }
        return max;
    }
}
