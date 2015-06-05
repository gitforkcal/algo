package com.test.algo.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rahul
 */
public class Knapsack {


    public static int size(int [] weight , int [] value , int item , int totalWeight , int noOfItems) {
        if(item == noOfItems) {
            return 0;
        }
        if(weight[item] > totalWeight) {
            return size(weight, value, item+1, totalWeight, noOfItems);
        }

        int i = Math.max(value[item] + size(weight, value, item+1, totalWeight - weight[item], noOfItems),
                size(weight, value, item+1, totalWeight, noOfItems));
        return i;
    }

    public static void main(String [] argv) {
        int [] weight = {10,30,20};
        int [] val =    {60,120,100};
        int W = 50;
        System.out.println(size(weight,val,0,W,3));
    }
}
