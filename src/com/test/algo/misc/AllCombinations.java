package com.test.algo.misc;

import java.util.Arrays;

/**
 * @author Rahul
 */
public class AllCombinations {

    public static void main(String [] argv) {
        int [] data = {1,2};
        printAllComb(data);
    }

    public static void printAllComb(int [] data) {
        int [] out = new int[data.length];
        comb(data,out,0);
    }

    private static void comb(int[] data, int[] out, int level) {
        if(level == data.length){
            System.out.println(Arrays.toString(out));
            return;
        }
        for(int i = 0 ; i < data.length ; i ++) {
            out[level] = data[i];
            comb(data, out, level+1);
        }
    }
}
