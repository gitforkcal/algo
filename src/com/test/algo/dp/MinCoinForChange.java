package com.test.algo.dp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rahul
 */
public class MinCoinForChange {

    public static void main(String [] argv) {
        int [] denom = {1,5,10,20,50};
        int change = 45;

        System.out.println("Min coins for change => " + makeChange(denom, change));
    }

    private static int makeChange(int[] denom, int change) {
        int [] value = new int[change+1];
        value[0] = 0;

        for(int amount = 1 ; amount <= change ;amount++) {

            List<Integer> probableCandidates = new LinkedList<Integer>();

            for(int index = 0 ; index < denom.length ; index++) {
                int currentDenomination = denom[index];
                if(currentDenomination <= amount) {
                    probableCandidates.add(value[amount-currentDenomination]);
                }
            }

            value[amount] = (Collections.min(probableCandidates) + 1);
            probableCandidates.clear();
        }
        return value[change];
    }
}
