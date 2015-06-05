package com.test.algo.misc;

/**
 * @author Rahul Bhattacharjee
 */
public class Permutationcode {

    public static void main(String [] argv) {
        permutation("abc".toCharArray(),0,3);
    }

    private static void permutation(char[] chars, int k, int length) {
        if(k == length-1) {
            System.out.println(new String(chars));
            return;
        }

        int pointer = length-1;
        for(int i = k ; i < length;i++) {
            swap(chars,k,pointer);
            permutation(chars, k+1, length);
            swap(chars,k,pointer);
            pointer--;
        }
    }

    private static void swap(char[] data , int a , int b) {
        char temp = data[a];
        data[a] =  data[b];
        data[b] = temp;
    }
}
