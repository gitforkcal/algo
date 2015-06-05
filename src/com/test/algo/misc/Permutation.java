package com.test.algo.misc;

import java.util.Arrays;

/**
 * Permutation.
 *
 * @author Rahul
 */
public class Permutation {

    public static void main(String [] argv) {
        permutation("abc".toCharArray());
    }

    private static void permutation(char[] chars) {
        permutation(chars,0,chars.length);
    }

    private static void permutation(char[] chars, int index, int length) {
        if(index+1 == length) {
            System.out.println(new String(chars));
            return;
        }
        //int end = length-1;
        for(int end = length-1 ; end >= 0 ; end--) {
            swap(chars,index,end);
            permutation(chars, index+1, length);
            swap(chars,index,end);
            //end--;
        }
    }

    private static void swap(char[] data , int a , int b) {
        char val = data[a];
        data[a] = data[b];
        data[b] = val;
    }
}
