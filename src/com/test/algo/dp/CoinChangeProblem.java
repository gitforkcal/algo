package com.test.algo.dp;

/**
 * @author Rahul
 */
public class CoinChangeProblem {
    // minimum coins to make a sum of M.

    private static int [] [] cache = new int [10][10];

    public static int sum(int demon , int sum) {
        if(cache[demon][sum] != 0) {
            System.out.println("Using cache.");
            return cache[demon][sum];
        }

        if(sum < demon || demon ==0){
            return 0;
        }
        if(sum == demon){
            return 1;
        }

        int max = Math.min(1+ sum(next(demon), sum - demon) , sum(next(demon),sum));
        cache[demon][sum] = max;
        return max;
    }

    public static int next(int current) {
        if(current == 2){
            return 3;
        } else if (current == 3) {
            return 4;
        } else if (current == 4) {
            return 5;
        } else {
            return 0;
        }
    }

    public static void main(String [] argv) {
        System.out.println("No of coins " + sum(2,5));
    }
}
