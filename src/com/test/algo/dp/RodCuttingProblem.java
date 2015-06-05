package com.test.algo.dp;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Try to do  the problem in both recursive and bottom up approach.
 *
 * @author Rahul
 */
public class RodCuttingProblem {

    public static void main(String [] argv) {
        int [] length = {1,2,3,4};
        int [] price = {1,5,8,9};

        int maxLength = 3;
        //System.out.println("Max price " + getMaxValue(length, price,maxLength));
        System.out.println("Max price " + getMaxValueRecur(length, price, maxLength));
    }

    private static int getMaxValueRecur(int[] length, int[] price, int maxLength) {
        if(maxLength == 0){
            return 0;
        }

        List<Integer> list = new LinkedList<Integer>();
        for(int i = 0 ; i < length.length ; i++) {
            if(length[i] <= maxLength) {
                int value = price[i] + getMaxValueRecur(length, price, (maxLength-length[i]));
                list.add(value);
            }
        }
        return Collections.max(list);
    }

    private static int getMaxValue(int[] length, int[] price , int maxLength) {
        int [] cache = new int[maxLength+1];
        cache[0] = 0;

        for(int startLength = 1 ; startLength <= maxLength ; startLength++) {

            List<Integer> tempList = new LinkedList<Integer>();

            for(int index = 0 ; index < length.length ; index++) {
                if(length[index] <= startLength) {
                    int value = cache[startLength-length[index]] + price[index];
                    tempList.add(value);
                }
            }
            cache[startLength] = Collections.max(tempList);
            tempList.clear();
        }
        return cache[maxLength];
    }
}
