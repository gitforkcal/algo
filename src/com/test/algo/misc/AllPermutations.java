package com.test.algo.misc;

import java.util.Arrays;

/**
 * @author Rahul
 */
public class AllPermutations {

    private static void printAllPermutations(int[] data) {
        int length = data.length;
        int [] buffer = new int[length+10];
        permutation(data,buffer,0);
    }

    private static void permutation(int[] data, int[] buffer, int count) {
        int length = data.length;
        if(length+10 == count){
            System.out.println(Arrays.toString(buffer));
            return;
        }
        for(int i = 0 ; i < length; i++) {
            buffer[count] = data[i];
            permutation(data, buffer, count+1);
        }
    }

    public static void main(String [] argv) {
        int []  data = {1,2};
        printAllPermutations(data);
    }
}
