package com.test.algo.dp;

/**
 * @author Rahul
 */
public class Knapsack1 {

    public static void main(String [] argv) {
        int [] weight = {1,4,2,3,5};
        int [] val =    {1,3,2,5,6};
        int W = 7;

        System.out.print("Max Val = " + packKnapsack(weight,val,0,W));
    }

    private static int packKnapsack(int[] weight, int[] val, int idx, int w) {
        if(idx == weight.length) {
            return 0;
        }

        if(weight[idx] > w) {
            return 0;
        }

        int first = val[idx] + packKnapsack(weight, val, idx+1, w-weight[idx]);
        int second = packKnapsack(weight, val, idx+1, w);

        if(first > second) {
            return first;
        } else {
            return second;
        }
    }
}
