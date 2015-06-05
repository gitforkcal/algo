package com.test.algo.misc;

/**
 * @author Rahul
 */
public class CoinChangeProblem {

    public static int noOfWays(int n , int denom) {
        int next = 0;
        int sum = 0;

        switch(denom) {
            case 25: next = 10;
                     break;
            case 10: next = 5;
                     break;
            case 5: next = 1;
                     break;
            case 1: return 1;
        }

        for(int i = 0 ; (i* denom) < n ; i++) {
            sum += noOfWays(n - (denom*i),next);
        }
        return sum;
    }

    public static void main(String [] argv) {
        System.out.println(noOfWays(100, 25));
    }
}
